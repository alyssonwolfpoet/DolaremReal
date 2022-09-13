package Dolar.src.dolar;//https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html
//https://simplificandoredes.com/http-requisicoes-get-post-api-java/

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class DolarBase {
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
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
