package com.miguelmjro.appstore.pearstroe.dbo;

import android.provider.BaseColumns;

import com.miguelmjro.appstore.pearstroe.Estructuras.Aplicacion;

import java.util.List;

import static android.R.attr.name;
import static android.R.id.list;

/**
 * Created by Miguel on 23/10/16.
 */

public abstract class DAOAplicacion implements BaseColumns  {
    public static final String NOMBRE_TABLA="aplicacion";

    public static final String ID="id";
    public static final String NAME="name";
    public static final String SUMMARY="summary";
    public static final String TITLE="title";
    public static final String CATEGORIA="id_categoria";
    public static final String ARTISTA="id_artista";
    public static final String PRECIO="precio";
    public static final String MONEDA="id_moneda";

    public static String queryAtualizaAplicaicones(Aplicacion app) {
        String sql=null;
        sql="UPDATE "+NOMBRE_TABLA+" SET "+NAME+"='"+app.getName()+"', ";
        sql=sql+TITLE+"='"+app.getTitle()+"', ";
        sql=sql+PRECIO+"="+app.getPrecio().getAumont();
        sql=sql+" WHERE "+ID+"="+app.getId();
        return sql;
    }
}
