package Dolar.src.dolar;

import java.io.IOException;
import java.text.ParseException;

public class Teste {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {

        teste();


    }

    public static void teste() throws IOException, InterruptedException, ParseException {
        Dolar.carregar_dados();
        System.out.println(Dolar.getCotacao_Dolar());
        System.out.println(Dolar.getData_criacao());
    }

}
