//https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html
//https://simplificandoredes.com/http-requisicoes-get-post-api-java/
package Dolar.src.dolar;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Dolar {

    public static final String URL_GET = "https://economia.awesomeapi.com.br/last/USD-BRL";
    private static float cotacao_Dolar;
    private static Date data_criacao;
    static String bodyToString, data_Cotacao;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static HttpClient client;
    static HttpRequest request;
    static HttpResponse<String> response;

    public Dolar() throws IOException, InterruptedException, ParseException {
        carregar_dados();
        System.out.println(response.statusCode());
        System.out.println(response.body());


    }

    public static float getCotacao_Dolar() {
        return cotacao_Dolar;
    }

    private static void setCotacao_Dolar() {
        int index_Inicial, index_Final;

        index_Inicial = bodyToString.indexOf("ask");
        index_Final = bodyToString.indexOf(",", index_Inicial);
        cotacao_Dolar = Float.parseFloat(bodyToString.substring(index_Inicial + 6, index_Final - 1));
    }

    public static Date getData_criacao() {
        return data_criacao;
    }

    private static void setData_criacao() throws ParseException {
        int index_Inicial, index_Final;
        index_Inicial = bodyToString.indexOf("create_date");
        index_Final = bodyToString.indexOf("}", index_Inicial);
        data_Cotacao = bodyToString.substring(index_Inicial + 14, index_Final - 1);
        data_criacao = dateFormat.parse(data_Cotacao);
    }

    public static void carregar_dados() throws IOException, InterruptedException, ParseException {
        // cliente HTTP
        client = HttpClient.newHttpClient();

        // criar a requisição
        request = HttpRequest.newBuilder().GET().timeout(Duration.ofSeconds(10)).uri(URI.create(URL_GET)).build();

        // enviando uma solicitação

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        bodyToString = response.body();

        setCotacao_Dolar();
        setData_criacao();

    }

}
