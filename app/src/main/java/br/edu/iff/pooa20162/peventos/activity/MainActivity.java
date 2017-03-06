package br.edu.iff.pooa20162.peventos.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.edu.iff.pooa20162.peventos.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamaTelaEventos(View v){
        Intent intent = new Intent(MainActivity.this, ListasEventosActivity.class);
        startActivity(intent);
    }
    private Context getContext(){
        return this;
    }
}
