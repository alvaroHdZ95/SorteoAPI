package api_manager;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * <h1>Gestor de peticions HTTP</h1>
 * Clase que gestiona peticiones HTTP y devuelve una respuesta a dichas peticiones.
 *
 * @author Álvaro Hernández Valero
 * @seeAlso <a href="https://servicios.elpais.com/sorteos/loteria-del-nino/api/">API</a>
 * @seeAlso <a href="https://classroom.google.com/u/1/c/NTQ3MTQwMTIwMzY2/a/NTgyMTU3MDcwOTU2/details">Tarea</a>
 */

public class HttpRequestManager {
    public HttpResponse<String> getHttpResponse(String schema, String server, String resource) throws Exception {
        resource = URLEncoder.encode(resource, StandardCharsets.UTF_8);
        String url = schema + server + resource;

        HttpClient httpClient = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .headers("Content-type", "Text/plain")
                .setHeader("User-Agent", "Mozilla/5.0")
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    }
}
