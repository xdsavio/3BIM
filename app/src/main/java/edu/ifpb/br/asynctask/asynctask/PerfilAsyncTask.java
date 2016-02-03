package edu.ifpb.br.asynctask.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import edu.ifpb.br.asynctask.activity.CalcularPerfilAntropometrico;
import edu.ifpb.br.asynctask.util.HttpService;
import edu.ifpb.br.asynctask.util.Response;


public class PerfilAsyncTask extends AsyncTask<JSONObject, Void, Response>{
    Context context;

    public PerfilAsyncTask(Context context) {
        this.context = context;
    }
//

    @Override
    protected Response doInBackground(JSONObject... valores) {
        Response response = null;

        try {

            response = HttpService.sendJSONPostResquest("calcularPerfilAntropometrico", valores[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == 200) {

                JSONObject json = new JSONObject(response.getContentValue());

                String valor = json.getString("valor");
                Log.i("NotificationWearApp", "Nome: " + valor);
                Toast.makeText(context, valor, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("NotificationWearApp", "JSONException: " + e);
        }
    }
}
