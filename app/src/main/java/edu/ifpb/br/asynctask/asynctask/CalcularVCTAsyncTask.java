package edu.ifpb.br.asynctask.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

import edu.ifpb.br.asynctask.util.HttpService;
import edu.ifpb.br.asynctask.util.Response;

/**
 * Created by Matheus on 02/02/2016.
 */
public class CalcularVCTAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    Context context;

    public CalcularVCTAsyncTask(Context context) {
        this.context = context;
    }

    protected Response doInBackground(JSONObject... valores) {

        Response response = null;

        try {

            response = HttpService.sendJSONPostResquest("calcularVCT", valores[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == 202) {

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
