package com.miguelmjro.appstore.pearstroe.dbo;

import android.provider.BaseColumns;

/**
 * Created by root on 23/10/16.
 */

public abstract class DAOCategoria implements BaseColumns {
    public static final String NOMBRE_TABLA="categorias";

    public static final String ID="id";
    public static final String LABEL="label";
    public static final String SCHEME="scheme";
    public static final String TERM="TERM";
}
