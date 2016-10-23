package com.miguelmjro.appstore.pearstroe.dbo;

import android.provider.BaseColumns;

/**
 * Created by Miguel on 23/10/16.
 */

public abstract class DAOAplicacion implements BaseColumns  {
    public static final String NOMBRE_TABLA="imagenes";

    public static final String ID="id";
    public static final String NAME="name";
    public static final String SUMMARY="summary";
    public static final String TITLE="title";
    public static final String CATEGORIA="id_categoria";
    public static final String ARTISTA="id_artista";
    public static final String PRECIO="precio";
    public static final String MONEDA="id_moneda";

}
