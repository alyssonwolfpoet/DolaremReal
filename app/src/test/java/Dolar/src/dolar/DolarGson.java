package Dolar.src.dolar;//https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html
//https://simplificandoredes.com/http-requisicoes-get-post-api-java/
//https://www.devmedia.com.br/trabalhando-com-json-em-java-o-pacote-org-json/25480
//https://www.devmedia.com.br/json-manipulacao-de-estruturas-complexas-na-linguagem-java/25505
//https://www.site24x7.com/pt/tools/json-para-java.html

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class DolarGson {
    public static final String URL_GET = "https://economia.awesomeapi.com.br/last/USD-BRL";

    public static void main(String[] args) throws IOException, InterruptedException {
        // cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();

        // enviando uma solicitação

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //imprimir o conteúdo recebido
        //System.out.println(response.statusCode());
        //System.out.println(response.body());

        Gson gson = new Gson();
        //JsonObject dolar = new JsonObject();
        String json = response.body();
        JsonObject dolar = gson.fromJson(json, JsonObject.class);
        System.out.println(dolar);


        //dolar.Application a = gson.fromJson(json,dolar.Application.class);
        //System.out.println(a.USDBRLObject.getAsk());


        System.out.println(dolar.getAsJsonArray("ask"));//valor da venda de dolar obs so da null nao sei pq

    }

}
