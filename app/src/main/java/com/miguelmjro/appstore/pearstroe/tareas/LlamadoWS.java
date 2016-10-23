package com.miguelmjro.appstore.pearstroe.tareas;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.miguelmjro.appstore.pearstroe.Inicio;
import com.miguelmjro.appstore.pearstroe.Splash;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by miguel on 21/10/16.
 */
public class LlamadoWS extends AsyncTask<String, Integer, String> {

    Splash splash;
    public LlamadoWS(Splash splash) {
        this.splash = splash;
    }
        protected String doInBackground(String... urls) {
            InputStream inputStream = null;
            String st_json = null;
            URL url=null;
            HttpURLConnection urlConnection=null;
            try {
                url=new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                urlConnection.setRequestProperty("Content-Type", "application/json");

                inputStream = urlConnection.getInputStream();
                // json is UTF-8 by default
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
                st_json = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try{if(inputStream != null)inputStream.close();
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return st_json;
        }

        protected void onPostExecute(String result) {
            Intent mainIntent = new Intent(splash, Inicio.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mainIntent.putExtra("json", result);
            splash.startActivity(mainIntent);
            splash.finish();
        }
}
