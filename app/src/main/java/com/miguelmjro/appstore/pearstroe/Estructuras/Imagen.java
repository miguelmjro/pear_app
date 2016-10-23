package com.miguelmjro.appstore.pearstroe.Estructuras;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by miguel on 21/10/16.
 */
public class Imagen {
    String url;
    int altura;
    Bitmap imagen;
    public Imagen(String url,int altura){
        this.url=url;
        this.altura=altura;
        imagen=null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
