package com.miguelmjro.appstore.pearstroe.tareas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;

import com.miguelmjro.appstore.pearstroe.Estructuras.Imagen;
import com.miguelmjro.appstore.pearstroe.Fragmentos.AplicacionesFragment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 23/10/16.
 */

public class Descargas extends AsyncTask<Imagen, Integer, String> {
    ImageView imagen;
    Imagen oimagen;
    public Bitmap loadedImage;
    public Descargas() {
    }

    protected String doInBackground(Imagen... url){
        this.oimagen=url[0];
        URL imagenUrl = null;
            try {
                imagenUrl = new URL(oimagen.getUrl());
                HttpURLConnection conn = (HttpURLConnection) imagenUrl.openConnection();
                conn.connect();
                loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
            }catch(IOException e) {
                System.out.println("Error cargando la imagen: "+e.getMessage());
                loadedImage=null;
                oimagen.setImagen(loadedImage);
            }
        return "carga terminada";

    }
    protected void onPostExecute(String bytes) {
        imagen.setImageBitmap(loadedImage);
        oimagen.setImagen(loadedImage);

    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
}