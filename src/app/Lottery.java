package app;
import app.LotteryLogic;

/**
 * <h1>Sorteo del Niño</h1>
 * Programa que a través de la API del Sorteo del Niño, muestra el resumen de premios y permite buscar un número para ver si ha sido premiado.
 *
 * @author Álvaro Hernández Valero
 * @seeAlso <a href="https://servicios.elpais.com/sorteos/loteria-del-nino/api/">API</a>
 * @seeAlso <a href="https://classroom.google.com/u/1/c/NTQ3MTQwMTIwMzY2/a/NTgyMTU3MDcwOTU2/details">Tarea</a>
 */

public class Lottery {
    public static void main(String[] args) {
        LotteryLogic.runApp();
    }
}
