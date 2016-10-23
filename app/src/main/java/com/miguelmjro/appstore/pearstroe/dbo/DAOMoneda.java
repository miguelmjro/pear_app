package com.miguelmjro.appstore.pearstroe.dbo;

import android.provider.BaseColumns;

/**
 * Created by root on 23/10/16.
 */

public abstract class DAOMoneda implements BaseColumns {
    public static final String NOMBRE_TABLA="moneda";

    public static final String ID="id";
    public static final String CURRENCYCODE="currencycode";
}
