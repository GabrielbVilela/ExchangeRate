package com.GabrielVilela.ExchangeRate.services;

import com.GabrielVilela.ExchangeRate.RecordTeste;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class Request {
    private String apiUrl = "https://v6.exchangerate-api.com/v6";
    private final String apiKey = "/7d53d2a5cc2c30474986ec71";

    public RecordTeste setApi(String api){
        String url = this.apiUrl + this.apiKey + api;
        return request(url);
    }


    private RecordTeste request(String api){
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder(URI.create(api)).build();

        try {
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
            return desserialização(resposta);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private RecordTeste desserialização(HttpResponse<String> resposta){
        Gson gson = new Gson();
        RecordTeste json = gson.fromJson(resposta.body(), RecordTeste.class);
        return json;
    }
}
