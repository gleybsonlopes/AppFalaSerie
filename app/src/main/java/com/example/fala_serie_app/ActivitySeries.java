package com.example.fala_serie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivitySeries extends AppCompatActivity {

    private AdapterSeriePersonalizado adapter;
    Context context;

    public static final String TAG_nome = "SERIE_NOME";
    public static final String TAG_descricao = "SERIE_DESCRICAO";
    public static final String TAG_icone = "TAG_ICONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_series);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        RecyclerView rvSeries = (RecyclerView) findViewById(R.id.rvSeries);


        List<Series> series = carregarSeries();

        SeriesAdapter adapter = new SeriesAdapter(series, this);

        rvSeries.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        layoutManager.scrollToPosition(0);
        rvSeries.setLayoutManager(layoutManager);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
//        rvSeries.setLayoutManager(gridLayoutManager);


        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        rvSeries.addItemDecoration(itemDecoration);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent it = new Intent(ActivitySeries.this, ActivityCadastrar.class);
                startActivity(it);

            }
        });

    }


    private List<Series> carregarSeries() {
        List<Series> series = new ArrayList<>();


        String[] array_series = getResources().getStringArray(R.array.array_series);
        String[] array_descricao = getResources().getStringArray(R.array.array_descricao);

        series.add(new Series(array_series[0], array_descricao[0], R.drawable.lacasadepapel));
        series.add(new Series(array_series[1], array_descricao[1], R.drawable.alteredcarbon));
        series.add(new Series(array_series[2], array_descricao[2], R.drawable.once));
        series.add(new Series(array_series[3], array_descricao[3], R.drawable.stranger));
        series.add(new Series(array_series[4], array_descricao[4], R.drawable.society));
        series.add(new Series(array_series[5], array_descricao[5], R.drawable.thehauting));

        return series;
    }


    }

