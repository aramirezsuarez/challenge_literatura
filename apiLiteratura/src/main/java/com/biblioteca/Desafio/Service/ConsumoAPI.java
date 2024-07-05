package com.biblioteca.Desafio.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumer {


    public String obtenerDatos(String url) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException("Error de IO al obtener datos de la URL: " + url, e);
        } catch (InterruptedException e) {
            throw new RuntimeException("La solicitud fue interrumpida: " + url, e);
        }

        // Obtener el cuerpo de la respuesta en formato JSON
        String jsonResponse = httpResponse.body();
        return jsonResponse;
    }
}
