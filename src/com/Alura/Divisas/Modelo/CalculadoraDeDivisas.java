package com.Alura.Divisas.Modelo;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CalculadoraDeDivisas {

    public void conversor(double cantidad, String monedaAnterior, String monedaConvertida) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/c94b1eaa1158dc9b619d21e1/pair/"+monedaAnterior+"/"+monedaConvertida;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        Valor monedas = gson.fromJson(json, Valor.class);
        System.out.println("Valor actual de la divisa: " + monedas.getConvertida());
        System.out.println("Valor convertido: " + monedas.getConvertida() * cantidad);
    }
}
