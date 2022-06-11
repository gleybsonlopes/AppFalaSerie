package com.example.fala_serie_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SeriesAdapter extends
        RecyclerView.Adapter<SeriesAdapter.ViewHolder> {



    public static final String TAG_nome = "SERIE_NOME";
    public static final String TAG_descricao = "SERIE_DESCRICAO";
    public static final String TAG_icone = "TAG_ICONE";

    private List<Series> series;
    private Context context;




    SeriesAdapter(List<Series> series, Context context){
        this.series = series;
        this.context = context;
    }


    @Override
    public SeriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View seriesView = inflater.inflate(R.layout.item_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(seriesView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Series serie = series.get(position);

        TextView textViewNome = holder.textViewNome;
        textViewNome.setText(serie.getNome());
        TextView textViewDescricao = holder.textViewDescricao;
        textViewDescricao.setText(serie.getDescricao());
        ImageView logo = holder.imageView;
        logo.setImageResource(serie.getImage());

    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewNome;
        private TextView textViewDescricao;
        private ImageView imageView;

       public ViewHolder (View itemView){
           super(itemView);
           textViewNome = (TextView) itemView.findViewById(R.id.item_ListPersonalizado_nome);
           textViewDescricao = (TextView) itemView.findViewById(R.id.item_ListPersonalizado_descricao);
           imageView = (ImageView) itemView.findViewById(R.id.imageView_Personalizado_serie);

           itemView.setOnClickListener(this);

           }


        @Override
        public void onClick(View view) {

           int position = getAdapterPosition();
           if(position != RecyclerView.NO_POSITION){
               Series serie = series.get(position);

               Intent it = new Intent(context, ActivitySerie.class);
               it.putExtra(TAG_nome, serie.getNome());
               it.putExtra(TAG_descricao, serie.getDescricao());
               it.putExtra(TAG_icone, serie.getImage());
               it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               view.getContext().startActivity(it);

           }

        }


    }


    }













