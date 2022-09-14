package com.example.dolaremreal;
//https://www.youtube.com/watch?v=GZf3CbiVEv0

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class D {
    public static void main(String[] args) {
        String dolar = null;
       try{
           URL urlDolar = new URL("https://economia.awesomeapi.com.br/last/USD-BRL");
           HttpURLConnection conexao = (HttpURLConnection) urlDolar.openConnection();
           conexao.setRequestMethod("GET");
           conexao.setRequestProperty("content-type","application/json");
           conexao.setDoInput(true);
           conexao.setConnectTimeout(3000);
           conexao.connect();
           dolar = conexao.getResponseMessage();
       } catch (ProtocolException e) {
           e.printStackTrace();
       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

        System.out.println(dolar);
    }

}
