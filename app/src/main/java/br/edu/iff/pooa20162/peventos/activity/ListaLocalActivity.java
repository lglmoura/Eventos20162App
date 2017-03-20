package br.edu.iff.pooa20162.peventos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.adapter.LocalAdapter;
import br.edu.iff.pooa20162.peventos.model.Local;

public class ListaLocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_locais);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaLocalActivity.this,LocalActivity.class);
                intent.putExtra("id",0);
                intent.putExtra("nome","");

                intent.putExtra("endereco","");


                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listas_locais, menu);
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
        final ArrayList<Local> locais  = (ArrayList) Local.listAll(Local.class);
        Log.e("++++++++++++++",String.valueOf(locais.size()));

        ListView lista = (ListView) findViewById(R.id.lvLocais);
        ArrayAdapter adapter = new LocalAdapter(this,locais);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaLocalActivity.this,LocalActivity.class);

                intent.putExtra("id",locais.get(i).getId().intValue());
                intent.putExtra("nome",locais.get(i).getNome());

                intent.putExtra("endereco",locais.get(i).getEndereco());


                startActivity(intent);

            }
        });


    }

}
