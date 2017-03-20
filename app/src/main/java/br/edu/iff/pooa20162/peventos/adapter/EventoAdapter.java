package br.edu.iff.pooa20162.peventos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.model.Evento;

/**
 * Created by aluno on 06/03/17.
 */

public class EventoAdapter extends ArrayAdapter<Evento> {

    private Context context = null;
    private ArrayList<Evento> eventos = null;


    public EventoAdapter(Context context, ArrayList<Evento> eventos) {
        super(context, R.layout.linhavento,eventos);
        this.context = context;
        this.eventos = eventos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhavento, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.tvllvNome);
        TextView local = (TextView) rowView.findViewById(R.id.tvllvLocal);
        TextView data = (TextView) rowView.findViewById(R.id.tvllvData);

        nome.setText(eventos.get(position).getNome());
        local.setText(eventos.get(position).getLocal().getNome());
        data.setText(eventos.get(position).getData());
        return rowView;
    }


}
