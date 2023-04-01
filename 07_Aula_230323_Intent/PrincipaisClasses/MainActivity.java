package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //1) Atributos (Referentes aos elementos da tela!!!)
    EditText txtNome,txtSobrenome;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Linkando' os elementos da tela com a programação
        txtNome = (EditText) findViewById(R.id.txtNominho);
        txtSobrenome = (EditText) findViewById(R.id.txtSobrenominho);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        // 3) Evento do botão
        btnEnviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*  !!!!!INTENT!!!!!
                    Classe responsável pela manipulação de
                    activities... Permitindo uma 'ligação' entre
                    elas além passagem de parâmetros!!!
                 */

                //Recuperando os valores das caixinhas
                String nome = txtNome.getText().toString();
                String sobrenome = txtSobrenome.getText().toString();

                //Instanciando a classe Intent
                Intent it = new Intent(MainActivity.this,
                        MainActivity2.class);

                //'Colocando' os valores
                it.putExtra("1",nome);
                it.putExtra("2",sobrenome);

                //Chamando a outra tela
                startActivity(it);
Luis            }
        });
    }
}