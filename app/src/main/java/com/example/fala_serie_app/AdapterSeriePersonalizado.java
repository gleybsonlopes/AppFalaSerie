package com.example.fala_serie_app;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterSeriePersonalizado extends BaseAdapter {

    private List<Series> series;
    private Activity act;

    public AdapterSeriePersonalizado(List<Series> series, Activity act) {
        this.series = series;
        this.act = act;
    }

    @Override
    public int getCount() {
        return series.size();
    }

    @Override
    public Object getItem(int position) {
        return series.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.activity_serie, parent, false);
        Series serie = series.get(position);

        TextView nomeSerie = (TextView) view.findViewById(R.id.textViewTituloSerie);
        TextView descricaoSerie = (TextView) view.findViewById(R.id.textViewDescricaoSerie);
        ImageView logoSerie = (ImageView) view.findViewById(R.id.imageViewSerie);

        nomeSerie.setText(serie.getNome());
        descricaoSerie.setText(serie.getDescricao());
        logoSerie.setImageResource(serie.getImage());

        return view;
    }
}
