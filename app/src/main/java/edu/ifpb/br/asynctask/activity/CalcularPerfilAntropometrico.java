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
import edu.ifpb.br.asynctask.asynctask.CalcularPAntroAsyncTask;

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

        JSONObject geral = new JSONObject();

        try {
            // Peso
            EditText pesoEditText = (EditText) v.findViewById(R.id.pesoEditTextPerfilAntropometrico);
            String peso = pesoEditText.getText().toString();
            geral.put("peso", peso);

            // Altura
            EditText alturaEditText = (EditText) v.findViewById(R.id.alturaEditTextPerfilAntropometrico);
            String altura = alturaEditText.getText().toString();
            geral.put("altura", altura);

            //Entrevistado
            JSONObject entrevistado = new JSONObject();

            //Sexo do Entrevistado
            int selectedID = radioSexo.getCheckedRadioButtonId();
            radioSexo = (RadioGroup) findViewById(selectedID);
            String sexo = radioSexo.toString();
            entrevistado.put("sexo", sexo);

            //Data de Nascimento
            EditText dataNascimentoEditTextPerfilAntropometrico = (EditText) v.findViewById(R.id.dataNascimentoEditTextPerfilAntropometrico);
            String dataNascimento = dataNascimentoEditTextPerfilAntropometrico.getText().toString();
            entrevistado.put("dataNascimento", dataNascimento);

            geral.put("entrevistado", entrevistado);
            //Enviar os dados de geral para o AsyncTask

            CalcularPAntroAsyncTask calcularPAntroAsyncTask = new CalcularPAntroAsyncTask(this);
            calcularPAntroAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
