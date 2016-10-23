package com.miguelmjro.appstore.pearstroe.tareas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 23/10/16.
 */

public class Descargas extends AsyncTask<String, Integer, String> {
    ImageView imagen;
    public Descargas() {
    }

    public Bitmap loadedImage;
    protected String doInBackground(String... url){
        System.out.println(url[0]);
        URL imagenUrl = null;
        try {
            imagenUrl = new URL(url[0]);
            HttpURLConnection conn = (HttpURLConnection) imagenUrl.openConnection();
            conn.connect();
            loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
        }catch(IOException e) {
            System.out.println("Error cargando la imagen: "+e.getMessage());
        }
        return "carga terminada";

    }
    protected void onPostExecute(String bytes) {
        System.out.println("comensando pos");
        imagen.setImageBitmap(loadedImage);
    }
}