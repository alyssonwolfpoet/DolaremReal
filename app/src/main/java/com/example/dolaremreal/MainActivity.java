package com.example.dolaremreal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextCotacao, editTextQtdDolar;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCotacao = findViewById(R.id.editTextCotacao);
        editTextQtdDolar = findViewById(R.id.editTextQtdDOlar);

        textResultado = findViewById(R.id.textResultado);

    }

    public  void  conveter(View view){
        double quantDolar = Double.parseDouble(editTextQtdDolar.getText().toString());
        double valorDolar = Double.parseDouble(editTextCotacao.getText().toString());

        double valorConvertido = valorDolar * quantDolar;

        DecimalFormat decimal = new DecimalFormat("0.00");
        String valorFormatado = decimal.format(valorConvertido);


        textResultado.setText("R$: " + valorFormatado);
    }

}