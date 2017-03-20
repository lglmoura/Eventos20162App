package br.edu.iff.pooa20162.peventos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.adapter.EventoAdapter;
import br.edu.iff.pooa20162.peventos.model.Evento;

public class ListasEventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListasEventosActivity.this,EventoActivity.class);
                intent.putExtra("id",0);
                intent.putExtra("nome","");
                intent.putExtra("local","");

                intent.putExtra("data","");
                intent.putExtra("capacidade",0);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listas_eventos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Evento> eventos  = (ArrayList) Evento.listAll(Evento.class);

        ListView lista = (ListView) findViewById(R.id.lvEventos);
        ArrayAdapter adapter = new EventoAdapter(this,eventos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListasEventosActivity.this,EventoActivity.class);

                intent.putExtra("id",eventos.get(i).getId().intValue());
                intent.putExtra("nome",eventos.get(i).getNome());
                intent.putExtra("local",eventos.get(i).getLocal().getId());
                intent.putExtra("data",eventos.get(i).getData());
                intent.putExtra("capacidade",eventos.get(i).getCapacidade());

                startActivity(intent);

            }
        });


    }

}
