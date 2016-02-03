package edu.ifpb.br.asynctask.activity;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;
import edu.ifpb.br.asynctask.asynctask.CalcularVCTAsyncTask;
import edu.ifpb.br.asynctask.R;
import edu.ifpb.br.asynctask.asynctask.*;

public class VCTActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_vctactivity);

        Button VCTButton = (Button) findViewById(R.id.calcularVCTButton);
        VCTButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        RadioGroup radioNivelEsporte = (RadioGroup) findViewById(R.id.radioNivelEsporte);
        RadioGroup radioSexo = (RadioGroup) findViewById(R.id.radioSexo);

     
        Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

        JSONObject regulus = new JSONObject();

        try {
            EditText pesoEditText = (EditText) v.findViewById(R.id.pesoEditText);
            String peso = pesoEditText.getText().toString();
            regulus.put("peso", peso);

            EditText alturaEditText = (EditText) v.findViewById(R.id.alturaEditText);
            String altura = alturaEditText.getText().toString();
            regulus.put("altura", altura);

            int selectedId = radioNivelEsporte.getCheckedRadioButtonId();
            radioNivelEsporte = (RadioGroup) findViewById(selectedId);
            String nivelEsporte = radioNivelEsporte.toString();

            regulus.put("nivelEsporte", nivelEsporte);

            JSONObject entrevistado = new JSONObject();

            int selectedID = radioSexo.getCheckedRadioButtonId();
            radioSexo = (RadioGroup) findViewById(selectedID);
            String sexo = radioSexo.toString();
            entrevistado.put("sexo", sexo);

            EditText dtNascimentoEditViewVCT = (EditText) v.findViewById(R.id.dtNascimentoEditViewVCT);
            String dataNascimento = dtNascimentoEditViewVCT.getText().toString();
            entrevistado.put("dataNascimento", dataNascimento);

            regulus.put("entrevistado", entrevistado);

            VCTAsyncTask calcularVCTAsyncTask = new VCTAsyncTask(this);
            VCTAsyncTask.execute(regulus);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}


