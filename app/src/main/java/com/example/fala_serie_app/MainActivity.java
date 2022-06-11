package com.example.fala_serie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
        EditText editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        ColorStateList linhaEdits = ContextCompat.getColorStateList(getApplicationContext(), android.R.color.holo_red_dark);

        ViewCompat.setBackgroundTintList(editTextLogin, linhaEdits);
        ViewCompat.setBackgroundTintList(editTextSenha, linhaEdits);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
                TextView textViewSenha = (TextView) findViewById(R.id.textViewSenha);
                EditText editTextLogin = (EditText) findViewById(R.id.editTextLogin);
                EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);
                String login = editTextLogin.getText().toString();
                String senha = editTextSenha.getText().toString();

                Intent it = new Intent(MainActivity.this, ActivitySeries.class);

                if(login.equals("processo@audax.mobi") && senha.equals("12345")){
                    alert("Login realizado com sucesso!");
                    startActivity(it);

                } else{
                    alert("Falha ao logar, verifique os dados!");
                }

            }
        });
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}