package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1) Atributos
    EditText txtSalario,txtNome;
    SeekBar barrinha;
    TextView lblNumero;
    Button btnSalvar;
    int valorBarra; //Para salvar o o valor do seekbar


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtSalario = (EditText) findViewById(R.id.txtSalario);
        lblNumero = (TextView) findViewById(R.id.lblValorSk);
        barrinha = (SeekBar) findViewById(R.id.skAumento);
        btnSalvar = (Button) findViewById(R.id.btnCalcular);

        //3) Evento do seekBar
        barrinha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Passando o valor vigente para o atributo
                valorBarra = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Quando o seekBar parar, atualizamos o valor
                //do lblNumero
                lblNumero.setText(valorBarra + " %");
            }
        });

        //4) Evento do botão
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperando valores do usuário
                String nome = txtNome.getText().toString();
                double salario = Double.parseDouble(
                           txtSalario.getText().toString());

                //Calculando o valor com aumento
                double novoValor = salario + (salario * valorBarra/100);

                //Instanciando a classe Intent para passarmos os valores
                //para outra Activity!!!!!
                Intent it = new Intent(MainActivity.this,
                                                    Tela2.class);

                //Passando os valores
                it.putExtra("nome",nome);
                it.putExtra("salario",salario+"");
                it.putExtra("aumento",valorBarra+"");
                it.putExtra("salarionovo",novoValor+"");

                //Chamando a outra Activity
                startActivity(it);


            }
        });




    }
}
