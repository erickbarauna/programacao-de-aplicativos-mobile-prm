package com.example.dinamica_020323;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNome, txtNasc, txtEmail;
    RadioButton sexoF, sexoM;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtNasc = (EditText) findViewById(R.id.txtNasc);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        sexoM = (RadioButton) findViewById(R.id.sexoM);
        sexoF = (RadioButton) findViewById(R.id.sexoF);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        //Evento Botao
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperando Valor txtNome
                String nome = txtNome.getText().toString();
                String nasc = txtNasc.getText().toString();
                String email = txtEmail.getText().toString();

                String sexo = "";

                if (sexoF.isChecked())
                {
                    sexo = "Feminino";
                }
                if (sexoM.isChecked())
                {
                    sexo = "Masculino";
                }

                Toast.makeText(MainActivity.this,
                                " Nome: " + nome +
                                    "\n Nascimento: " + nasc +
                                    "\n E-mail: " + email +
                                    "\n Sexo: " + sexo,
                                    Toast.LENGTH_LONG).show();

            }
        });

    }
}