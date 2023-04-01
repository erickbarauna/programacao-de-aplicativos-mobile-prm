package com.example.myapplication;

import static java.net.Proxy.Type.HTTP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.params.HttpParams;

import java.util.Calendar;

public class Tela2 extends AppCompatActivity {

    //1) Atributos
    Button btnApp,btnEmail,btnSite,btnAgenda,btnLigacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //2) Elementos da tela
        btnApp = (Button) findViewById(R.id.btnApp);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnSite = (Button) findViewById(R.id.btnSite);
        btnAgenda = (Button) findViewById(R.id.btnAg);
        btnLigacao = (Button) findViewById(R.id.btnLigar);

        //Chamando a classe Intent
        Intent it = getIntent();

        //Salvando os valores da outra tela, em variáveis locais
        String nome = it.getStringExtra("nome");
        String salario = it.getStringExtra("salario");
        String salarioNovo =it.getStringExtra("salarionovo");
        String aumento = it.getStringExtra("aumento");

        //Mostrando os valores
        Toast.makeText(Tela2.this,
                            "Nome: "+nome+
                              "\n Sal.:"+salario+
                              "\n Aumento:"+aumento+
                              "\n Sal. Novo:"+salarioNovo,
                                Toast.LENGTH_LONG).show();


        //Btn App
        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Intent para abrir outra aplicação
                Intent it = new Intent();
                it.setAction(Intent.ACTION_MAIN);
                it.addCategory(Intent.CATEGORY_LAUNCHER);
                it.setComponent(new ComponentName(
                              "com.android.calculator2",
                        "com.android.calculator2.Calculator"));
                startActivity(it);
            }
        });

        //BtnLigacao
        btnLigacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:979801104");
                Intent it = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(it);
            }
        });

        //BtnSite
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri paginaWeb = Uri.parse("https://google.com");
                Intent it = new Intent(Intent.ACTION_VIEW,paginaWeb);
                startActivity(it);
            }
        });

        //btnAgenda
        btnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_INSERT,
                             CalendarContract.Events.CONTENT_URI);

                Calendar inicioHora = Calendar.getInstance();
                inicioHora.set(2023,5,23,7,30);
                Calendar finalHora = Calendar.getInstance();
                finalHora.set(2023,5,23,12,30);

                it.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                                 inicioHora.getTime());
                it.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        finalHora.getTime());
                it.putExtra(CalendarContract.Events.TITLE,
                           "Aula de Pilates");
                it.putExtra(CalendarContract.Events.EVENT_LOCATION,
                        "Na sua casa otário!");
                startActivity(it);

            }
        });

        //btnEmail
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/html");
                it.putExtra(Intent.EXTRA_EMAIL,new String[]{"joao@gmail.com"});
                it.putExtra(Intent.EXTRA_SUBJECT,"Email de amor!");
                it.putExtra(Intent.EXTRA_TEXT,"Boa tarde Joao, eu te amo");
                startActivity(it);
            }
        });




    }
}
