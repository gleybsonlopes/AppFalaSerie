package com.example.fala_serie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivitySerie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_serie);

        TextView tituloSerie = (TextView) findViewById(R.id.textViewTituloSerie);
        TextView descricaoSerie = (TextView) findViewById(R.id.textViewDescricaoSerie);
        ImageView logoSerie = (ImageView) findViewById(R.id.imageViewSerie);

        Intent it = getIntent();
        String nome = it.getStringExtra(ActivitySeries.TAG_nome);
        String descricao = it.getStringExtra(ActivitySeries.TAG_descricao);
        int logo = it.getIntExtra(ActivitySeries.TAG_icone, R.drawable.ic_launcher_foreground);

        tituloSerie.setText(nome);
        descricaoSerie.setText(descricao);
        logoSerie.setImageResource(logo);
    }
}