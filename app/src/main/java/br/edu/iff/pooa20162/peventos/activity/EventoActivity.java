package br.edu.iff.pooa20162.peventos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.model.Evento;
import br.edu.iff.pooa20162.peventos.model.Local;

public class EventoActivity extends Activity {

    EditText nome,  data, capacidade;
    Spinner spLocal;
    Button btsalvar,btalterar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String nomep     = (String) intent.getSerializableExtra("nome");

        String datap     = (String) intent.getSerializableExtra("data");
        int capacidadep  = (int)  intent.getSerializableExtra("capacidade");

        EditText nome = (EditText) findViewById(R.id.etNomeEvento);
        nome.setText(nomep);


        final ArrayList<Local> locais  = (ArrayList) Local.listAll(Local.class);

        ArrayAdapter<Local> adapter = new ArrayAdapter<Local>(this, android.R.layout.simple_spinner_item, locais);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spLocal = (Spinner) findViewById(R.id.spLocalinEvento);
        spLocal.setAdapter(adapter);


        EditText data = (EditText) findViewById(R.id.etDataEvento);
        data.setText(datap);

        EditText capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);
        capacidade.setText(Integer.toString(capacidadep));


        btsalvar = (Button) findViewById(R.id.btSalvarEvento);
        btalterar = (Button) findViewById(R.id.btAlterarEvento);


        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);

        }


    }

    public void salvar() {


        nome = (EditText) findViewById(R.id.etNomeEvento);
        Local local  = ((Local)spLocal.getSelectedItem());


        data = (EditText) findViewById(R.id.etDataEvento);
        capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);


        Evento evento = new Evento(nome.getText().toString(),local,
                data.getText().toString(),
                Integer.parseInt(capacidade.getText().toString()));

        evento.save();

        Toast.makeText(this,"Evento Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        nome = (EditText) findViewById(R.id.etNomeEvento);
        Local local  = ((Local)spLocal.getSelectedItem());

        data = (EditText) findViewById(R.id.etDataEvento);
        capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);

        Evento evento = Evento.findById(Evento.class, id);

        evento.setNome(nome.getText().toString());
        evento.setLocal(local);
        
        evento.setData(data.getText().toString());
        evento.setCapacidade(Integer.parseInt(capacidade.getText().toString()));

        evento.save();

        Toast.makeText(this,"Evento Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}