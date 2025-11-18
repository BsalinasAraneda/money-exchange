package com.practice.apiexchange.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String API_KEY_EXANCHE = "08f7797705776a6bbb2c2ec7";

    // Cliente HTTP reutilizable (mejor rendimiento)
    private final HttpClient httpClient;

    // Generando la instancia en el constructor de la clase para reutilizar HttpClient
    public ApiClient(){
        this.httpClient = HttpClient.newHttpClient();
    }


    public String busquedaPrefinida(String base, String target, double monto) throws IOException, InterruptedException {
        // Construimos el URI de manera segura
        URI BASE_URL_API_EXANCGHE = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY_EXANCHE+"/pair/"+base+"/"+target+"/"+monto);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(BASE_URL_API_EXANCGHE)
                .GET()
                .build();
        HttpResponse<String> response  = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200){
            throw new RuntimeException("ERROR HTTP: " + response.statusCode());
        }

        return response.body();
    }

    public String busquedaPersonalizada(String base, String target, double monto) throws IOException, InterruptedException {
        // Construimos el URI de manera segura
        URI URL_BY_DIVISE = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY_EXANCHE+"/pair/"+base+"/"+target+"/"+monto);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URL_BY_DIVISE)
                .GET()
                .build();
        HttpResponse<String> response  = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() != 200){
            throw new RuntimeException("ERROR HTTP: " + response.statusCode());
        }

        return response.body();
    }

    public String obtenerHistoricoDivisa(String year, String target, String month, String day) throws IOException, InterruptedException {
        URI URL_GET_HISTORY =
                URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY_EXANCHE+"/history/"+target+"/"+year+"/"+month+"/"+day);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URL_GET_HISTORY)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200){
            throw new RuntimeException("ERROR HTTP: " + response.statusCode());
        }

        return response.body();
    }

}
