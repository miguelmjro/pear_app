package com.miguelmjro.appstore.pearstroe.dbo;

import android.graphics.Bitmap;
import android.provider.BaseColumns;

/**
 * Created by root on 23/10/16.
 */



public abstract class DAOImagen implements BaseColumns{
    public static final String NOMBRE_TABLA="imagenes";

    public static final String ID="id";
    public static final String ALTURA="altura";
    public static final String IMAGEN="imagen";
    public static final String APLICACION="id_app";//llave foranea


}
