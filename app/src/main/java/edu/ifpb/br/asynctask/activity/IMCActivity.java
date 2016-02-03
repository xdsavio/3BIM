package edu.ifpb.br.asynctask.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import edu.ifpb.br.asynctask.R;
import edu.ifpb.br.asynctask.asynctask.*;

import edu.ifpb.br.asynctask.R;

public class IMCActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);

        Button imcButton = (Button) findViewById(R.id.calcularIMCButton);
        imcButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

        JSONObject regulus = new JSONObject();

        try {
            EditText pesoEditText = (EditText) findViewById(R.id.pesoEditText);
            String peso = pesoEditText.getText().toString();
            regulus.put("peso", peso);

            EditText alturaEditText = (EditText) findViewById(R.id.alturaEditText);
            String altura = alturaEditText.getText().toString();
            regulus.put("altura", altura);

            IMCAsyncTask IMCAsyncTask = new IMCAsyncTask(this);
            IMCAsyncTask.execute(regulus);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
