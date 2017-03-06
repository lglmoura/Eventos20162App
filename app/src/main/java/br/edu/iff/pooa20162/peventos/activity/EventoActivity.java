package br.edu.iff.pooa20162.peventos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.model.Evento;

public class EventoActivity extends Activity {

    EditText nome, local, endereco, data, capacidade;
    Button btsalvar,btalterar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String nomep     = (String) intent.getSerializableExtra("nome");
        String localp    = (String) intent.getSerializableExtra("local");
        String enderecop = (String) intent.getSerializableExtra("endereco");
        String datap     = (String) intent.getSerializableExtra("data");
        int capacidadep  = (int)  intent.getSerializableExtra("capacidade");

        EditText nome = (EditText) findViewById(R.id.etNomeEvento);
        nome.setText(nomep);

        EditText local = (EditText) findViewById(R.id.etLocalEvento);
        local.setText(localp);

        EditText endereco = (EditText) findViewById(R.id.etEnderecoEvento);
        endereco.setText(enderecop);

        EditText data = (EditText) findViewById(R.id.etDataEvento);
        local.setText(localp);

        EditText capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);
        capacidade.setText(capacidadep);


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
        local = (EditText) findViewById(R.id.etLocalEvento);
        endereco = (EditText) findViewById(R.id.etEnderecoEvento);
        data = (EditText) findViewById(R.id.etDataEvento);
        capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);

        Evento evento = new Evento(nome.getText().toString(),local.getText().toString(),
                endereco.getText().toString(),data.getText().toString(),
                Integer.getInteger(capacidade.getText().toString()).intValue());

        evento.save();

        Toast.makeText(this,"Evento Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        nome = (EditText) findViewById(R.id.etNomeEvento);
        local = (EditText) findViewById(R.id.etLocalEvento);
        endereco = (EditText) findViewById(R.id.etEnderecoEvento);
        data = (EditText) findViewById(R.id.etDataEvento);
        capacidade = (EditText) findViewById(R.id.etCapacidadeEvento);

        Evento evento = Evento.findById(Evento.class, id);

        evento.setNome(nome.getText().toString());
        evento.setLocal(local.getText().toString());
        evento.setEndereco(endereco.getText().toString());
        evento.setData(data.getText().toString());
        evento.setCapacidade(Integer.getInteger(capacidade.getText().toString()).intValue());

        evento.save();

        Toast.makeText(this,"Evento Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}