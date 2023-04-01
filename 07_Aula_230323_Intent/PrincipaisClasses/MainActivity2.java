package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    // 1) Atributos
    TextView txtMens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 2) 'Linkando' os elementos da tela
        txtMens = (TextView) findViewById(R.id.txtMensagenzinha);

        // 3) Instanciando a classe Intent
        Intent it = new Intent();

        // 4) Recuperando os valores passados pela outra tela
        String textinho = "Nome:"+it.getStringExtra("1")
                        + "\n Sobrenome"+it.getStringExtra("2");

        // 5) Mostrando a mens. com os valores passados!!!!!! :)
        txtMens.setText(textinho);
    }
}