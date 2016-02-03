package edu.ifpb.br.asynctask.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;

import edu.ifpb.br.asynctask.R;
import edu.ifpb.br.asynctask.asynctask.PerfilAsyncTask;

public class CalcularPerfilAntropometrico extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_perfil_antropometrico);

        Button calcularPerfilAntropometrico = (Button) findViewById(R.id.calcularPerfilAntropometricoButton);
        calcularPerfilAntropometrico.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        RadioGroup radioSexo = (RadioGroup) findViewById(R.id.radioSexoPerfilAntropometrico);

        JSONObject regulus = new JSONObject();

        try {
            
            EditText pesoEditText = (EditText) v.findViewById(R.id.pesoEditTextPerfilAntropometrico);
            String peso = pesoEditText.getText().toString();
            regulus.put("peso", peso);

            
            EditText alturaEditText = (EditText) v.findViewById(R.id.alturaEditTextPerfilAntropometrico);
            String altura = alturaEditText.getText().toString();
            regulus.put("altura", altura);

            
            JSONObject entrevistado = new JSONObject();

            
            int selectedID = radioSexo.getCheckedRadioButtonId();
            radioSexo = (RadioGroup) findViewById(selectedID);
            String sexo = radioSexo.toString();
            entrevistado.put("sexo", sexo);

            EditText dataNascimentoEditTextPerfilAntropometrico = (EditText) v.findViewById(R.id.dataNascimentoEditTextPerfilAntropometrico);
            String dataNascimento = dataNascimentoEditTextPerfilAntropometrico.getText().toString();
            entrevistado.put("dataNascimento", dataNascimento);

            regulus.put("entrevistado", entrevistado);
           

            PerfilAsyncTask PerfilAsyncTask = new PerfilAsyncTask(this);
            PerfilAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
