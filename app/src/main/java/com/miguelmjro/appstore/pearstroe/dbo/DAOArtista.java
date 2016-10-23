package com.miguelmjro.appstore.pearstroe.dbo;

import android.provider.BaseColumns;

/**
 * Created by Miguel on 23/10/16.
 */

public abstract class DAOArtista implements BaseColumns {
    public static final String NOMBRE_TABLA="artista";

    public static final String ID="id";
    public static final String NAME="name";
    public static final String PAGINA="pagina";//tiene q ser unica
}
