package com.miguelmjro.appstore.pearstroe.Estructuras;

import android.media.Image;

/**
 * Created by miguel on 21/10/16.
 */
public class Imagen {
    String url;
    int altura;
    Image imagen;
    boolean descargada;
    public Imagen(String url,int altura){
        this.url=url;
        this.altura=altura;
        imagen=null;
        descargada=false;
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

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public boolean isDescargada() {
        return descargada;
    }

    public void setDescargada(boolean descargada) {
        this.descargada = descargada;
    }
}
