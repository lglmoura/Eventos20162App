package br.edu.iff.pooa20162.peventos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.peventos.R;
import br.edu.iff.pooa20162.peventos.model.Local;

public class LocalActivity extends Activity {

    EditText nome,  endereco;
    Button btsalvar,btalterar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String nomep     = (String) intent.getSerializableExtra("nome");

        String enderecop = (String) intent.getSerializableExtra("endereco");


        EditText nome = (EditText) findViewById(R.id.etNomeLocal);
        nome.setText(nomep);


        EditText endereco = (EditText) findViewById(R.id.etEnderecoLocal);
        endereco.setText(enderecop);

        btsalvar = (Button) findViewById(R.id.btSalvarLocal);
        btalterar = (Button) findViewById(R.id.btAlterarLocal);


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

        nome = (EditText) findViewById(R.id.etNomeLocal);

        endereco = (EditText) findViewById(R.id.etEnderecoLocal);


        Local local = new Local(nome.getText().toString(), endereco.getText().toString());

        local.save();

        Toast.makeText(this,"Local Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        nome = (EditText) findViewById(R.id.etNomeEvento);

        endereco = (EditText) findViewById(R.id.etEnderecoEvento);


        Local local = Local.findById(Local.class, id);

        local.setNome(nome.getText().toString());

        local.setEndereco(endereco.getText().toString());

        local.save();

        Toast.makeText(this,"Local Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
