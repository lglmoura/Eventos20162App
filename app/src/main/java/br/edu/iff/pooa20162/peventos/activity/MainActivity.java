package br.edu.iff.pooa20162.peventos.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.edu.iff.pooa20162.peventos.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamaTelaEventos(View v){
        Toast.makeText(this,"",Toast.LENGTH_SHORT);
    }
}
