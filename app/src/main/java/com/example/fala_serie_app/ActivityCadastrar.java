package com.example.fala_serie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityCadastrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().hide();


        Button btnCadastro = (Button) findViewById(R.id.btnCadastro);
        EditText editTextNomeCadastrar = (EditText) findViewById(R.id.editTextNomeCadastro);
        EditText editTextDescricaoCadastrar = (EditText) findViewById(R.id.editTextDescricaoCadastro);

        ColorStateList linhaEdits = ContextCompat.getColorStateList(getApplicationContext(), android.R.color.holo_red_dark);

        ViewCompat.setBackgroundTintList(editTextNomeCadastrar, linhaEdits);
        ViewCompat.setBackgroundTintList(editTextDescricaoCadastrar, linhaEdits);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextNomeCadastrar.length() >= 1 && editTextDescricaoCadastrar.length() >= 1){
                    alert("Cadastro de série realizado com sucesso!");
                    Intent it = new Intent(ActivityCadastrar.this, ActivitySeries.class);
                    startActivity(it);

                } else{
                    alert("Falha ao cadastrar a série, verifique se todos os campos estão preenchidos. ");
                }

            }

        });
    }
    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}