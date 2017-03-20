package br.edu.iff.pooa20162.peventos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.model.Evento;
import br.edu.iff.pooa20162.peventos.model.Local;

public class EventoActivity extends Activity {

    EditText nome,  data, capacidade;
    Spinner local;
    Button btsalvar,btalterar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String nomep     = (String) intent.getSerializableExtra("nome");
        Local localp     = (Local) intent.getSerializableExtra("local");
        String datap     = (String) intent.getSerializableExtra("data");
        int capacidadep  = (int)  intent.getSerializableExtra("capacidade");

        EditText nome = (EditText) findViewById(R.id.etNomeEvento);
        nome.setText(nomep);

        Spinner local = (Spinner) findViewById(R.id.spLocalinEvento);
        //local..setText(localp);


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

        /*
        nome = (EditText) findViewById(R.id.etNomeEvento);
        local = (Spinner) findViewById(R.id.spLocalinEvento);

        data = (EditText) findViewById(R.id.etDataEvento);
        capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);


        Evento evento = new Evento(nome.getText().toString(),local.getText().toString(),
                data.getText().toString(),
                Integer.parseInt(capacidade.getText().toString()));

        evento.save();
        */
        Toast.makeText(this,"Evento Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {
        /*
        nome = (EditText) findViewById(R.id.etNomeEvento);
        local = (EditText) findViewById(R.id.etLocalEvento);

        data = (EditText) findViewById(R.id.etDataEvento);
        capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);

        Evento evento = Evento.findById(Evento.class, id);

        evento.setNome(nome.getText().toString());
        evento.setLocal(local.getText().toString());
        evento.setEndereco(endereco.getText().toString());
        evento.setData(data.getText().toString());
        evento.setCapacidade(Integer.parseInt(capacidade.getText().toString()));

        evento.save();
        */
        Toast.makeText(this,"Evento Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}