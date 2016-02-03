package edu.ifpb.br.asynctask.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.ifpb.br.asynctask.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoCalcIMC = (Button) findViewById(R.id.calcularIMCButtonMain);
        Button botaoCalcVCT = (Button) findViewById(R.id.calcularVCTButtonMain);
        Button botaoCalcPerfil = (Button) findViewById(R.id.calcularPerfilAntropometricoMain);

        botaoCalcIMC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                calcIMC();
            }
        });
        botaoCalcVCT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                calcVCT();
            }
        });
        botaoCalcPerfil.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                calcPerfil();
            }
        });

    }
    public void calcIMC (){
        startActivity(new Intent(this, CalcularIMCActivity.class));
    }
    public void calcVCT (){
        startActivity(new Intent(this, CalcularVCTActivity.class));
    }
    public void calcPerfil(){
        startActivity(new Intent(this, CalcularPerfilAntropometrico.class));
    }

}
