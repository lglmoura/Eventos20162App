package br.edu.iff.pooa20162.peventos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.model.Local;

/**
 * Created by aluno on 06/03/17.
 */

public class LocalAdapter extends ArrayAdapter<Local> {

    private Context context = null;
    private ArrayList<Local> locais = null;


    public LocalAdapter(Context context, ArrayList<Local> locais) {
        super(context, R.layout.linhavento,locais);
        this.context = context;
        this.locais = locais;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhavento, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.tvllvNome);

        nome.setText(locais.get(position).getNome());
        
        return rowView;
    }


}
