package app;

import api_manager.HttpRequestManager;
import api_manager.Prizes;
import api_manager.Searches;
import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Sorteo del Niño</h1>
 * Clase con los métodos necesarios para que el programa Lottery.java se conecte con la API para su correcto funcionamiento.
 *
 * @author Álvaro Hernández Valero
 * @seeAlso <a href="https://servicios.elpais.com/sorteos/loteria-del-nino/api/">API</a>
 * @seeAlso <a href="https://classroom.google.com/u/1/c/NTQ3MTQwMTIwMzY2/a/NTgyMTU3MDcwOTU2/details">Tarea</a>
 */

public class LotteryLogic {

    // FIELDS
    private static Scanner input = new Scanner(System.in);

    private static final String MENU = """
            BIENVENIDO!! ¿En qué puedo ayudarle?
            
            1) Mostrar toda la información sobre los números premiados en el último sorteo.
            2) Comprobar si su número tiene premio.
            
            0) Salir.
            """;

    private static final String ERR_MSG_BAD_OPTION = "Opción no disponible. Pruebe de nuevo, por favor.";
    private static final String MSG_EXIT = "Gracias y hasta la próxima!!";
    private static final String MSG_LOTTERY_OK = "El sorteo ha terminado y existe una lista oficial en PDF.";
    private static final String MSG_URL_ONLAE = "Puede consultar la lista oficial en el siguiente enlace: ";
    private static final String ERR_MSG_LOTTERY_NOT_OK = "En estos momentos no hay una lista oficial con los números premiados";
    private static final String MSG_REQUEST_LOTTERY_NUMBER = "Inserte el número del boleto, por favor: ";
    private static final String ERR_MSG_BAD_LOTTERY_NUMBER = "Introduzca un número entre 0 y 99999, por favor.";
    private static boolean flag_exit;


    // METHODS
    public static void runApp() {
        int option;
        flag_exit = false;

        do {
            System.out.println(MENU);

            try {
                option = Integer.parseInt(input.nextLine());
            }
            catch (NumberFormatException exception) {
                System.err.println(ERR_MSG_BAD_OPTION);
                continue;
            }

            switch (option) {
                case 0 -> {
                    flag_exit = true;
                    System.out.println(MSG_EXIT);
                }
                case 1 -> showPrizes();
                case 2 -> checkNumber();
                default -> System.err.println(ERR_MSG_BAD_OPTION);
            }

        } while (!flag_exit);
    }

    private static HttpResponse<String> getResponse(String resource) {
        final String schema = "http://";
        String server = "api.elpais.com/ws/LoteriaNinoPremiados?n=";


        HttpRequestManager requestManager = new HttpRequestManager();

        try {

            HttpResponse<String> response = requestManager.getHttpResponse(schema, server, resource);

            if (response.statusCode() == HttpURLConnection.HTTP_OK) {
                return response;
            }
            else {
                System.out.println("Error " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void showPrizes() {
        HttpResponse<String> response = getResponse("resumen");

        if (response == null) {
            flag_exit = true;
            return;
        }

        String jsonResponse = response.body();
        jsonResponse = jsonResponse.replace("premios=", "");
        Gson gson = new Gson();

        Prizes prizes = gson.fromJson(jsonResponse, Prizes.class);

        if (!prizes.getFraseTexto().equals(MSG_LOTTERY_OK)) {
            System.out.println(ERR_MSG_LOTTERY_NOT_OK);
        }

        System.out.println(MSG_URL_ONLAE + prizes.getPdfURL());
        System.out.println("Primer premio: " + prizes.getPremio1());
        System.out.println("Segundo premio: " + prizes.getPremio2());
        System.out.println("Tercer premio: " + prizes.getPremio3());
        System.out.println("Las 2 extracciones de 4 cifras son: " + Arrays.toString(prizes.getExtracciones4cifras()));
        System.out.println("Las 14 extracciones de 3 cifras son: " + Arrays.toString(prizes.getExtracciones3cifras()));
        System.out.println("Las 5 extracciones de 2 cifras son: " + Arrays.toString(prizes.getExtracciones2cifras()));
        System.out.println("Los 3 reintegros son: " + Arrays.toString(prizes.getReintegros()));
    }

    private static void checkNumber() {
        int lotteryNum = 0;
        boolean validNumber = true;
        System.out.println(MSG_REQUEST_LOTTERY_NUMBER);

        do{
            try {
                lotteryNum = Integer.parseInt(input.nextLine());
                if (lotteryNum < 0 || lotteryNum > 99999) {
                    throw new Exception();
                }
            } catch (Exception e) {
                validNumber = false;
                System.err.println(ERR_MSG_BAD_LOTTERY_NUMBER);
            }
        } while (!validNumber);

        HttpResponse<String> response = getResponse(Integer.toString(lotteryNum));

        if (response == null) {
            flag_exit = true;
            return;
        }

        String jsonResponse = response.body();
        jsonResponse = jsonResponse.replace("busqueda=", "");
        Gson gson = new Gson();

        Searches busqueda = gson.fromJson(jsonResponse, Searches.class);

        if (Integer.parseInt(busqueda.getPremio()) == 0) {
            System.out.println("El número " + busqueda.getNumero() + " no ha sido premiado. ¡No desista!");
            return;
        }
        System.out.println("El número " + busqueda.getNumero() + " tiene " + busqueda.getPremio() + "€ de premio. " +
                "¡Felicidades!");
    }
}
