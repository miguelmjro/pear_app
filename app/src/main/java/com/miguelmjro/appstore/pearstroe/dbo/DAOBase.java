package com.miguelmjro.appstore.pearstroe.dbo;


import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.miguelmjro.appstore.pearstroe.Estructuras.Aplicacion;
import com.miguelmjro.appstore.pearstroe.Estructuras.Categoria;

import java.util.List;

/**
 * Created by root on 23/10/16.
 */

public class DAOBase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PearAPP.db";
    public DAOBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS "+DAOArtista.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS "+DAOAplicacion.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS "+DAOCategoria.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS "+DAOImagen.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS "+DAOMoneda.NOMBRE_TABLA);
        db.execSQL("CREATE TABLE " + DAOArtista.NOMBRE_TABLA + " ("
                + DAOArtista._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +DAOArtista.ID + " TEXT NOT NULL,"
                + DAOArtista.NAME + " TEXT NOT NULL,"
                + DAOArtista.PAGINA + " TEXT NOT NULL,"
                + "UNIQUE (" + DAOArtista.ID + "),"
                + "UNIQUE("+ DAOArtista.PAGINA+"))");

        db.execSQL("CREATE TABLE " + DAOCategoria.NOMBRE_TABLA + " ("
                + DAOCategoria._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOCategoria.ID + " TEXT NOT NULL,"
                + DAOCategoria.LABEL + " TEXT NOT NULL,"
                + DAOCategoria.SCHEME + " TEXT NOT NULL,"
                + DAOCategoria.TERM + " TEXT NOT NULL,"
                + "UNIQUE (" + DAOCategoria.ID + "))");

        db.execSQL("CREATE TABLE " + DAOMoneda.NOMBRE_TABLA + " ("
                + DAOMoneda._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOMoneda.ID + " TEXT NOT NULL,"
                + DAOMoneda.CURRENCYCODE + " TEXT NOT NULL,"
                + "UNIQUE (" + DAOMoneda.ID + "))");

        db.execSQL("CREATE TABLE " + DAOAplicacion.NOMBRE_TABLA + " ("
                + DAOAplicacion._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOAplicacion.ID + " TEXT NOT NULL,"
                + DAOAplicacion.NAME + " TEXT NOT NULL,"
                + DAOAplicacion.SUMMARY + " TEXT NOT NULL,"
                + DAOAplicacion.TITLE + " TEXT NOT NULL,"
                + DAOAplicacion.PRECIO + " REAL NOT NULL,"
                + DAOAplicacion.MONEDA + " INTEGER NOT NULL,"
                + DAOAplicacion.ARTISTA + " INTEGER NOT NULL,"
                + DAOAplicacion.CATEGORIA + " INTEGER NOT NULL,"
                + "UNIQUE (" + DAOAplicacion.ID + ")," +
                "FOREIGN KEY("+DAOAplicacion.MONEDA +") REFERENCES "+
                    DAOMoneda.NOMBRE_TABLA+"("+DAOMoneda._ID+")," +
                "FOREIGN KEY("+DAOAplicacion.ARTISTA+") REFERENCES "+
                    DAOArtista.NOMBRE_TABLA+"("+DAOArtista._ID+"),"+
                "FOREIGN KEY("+DAOAplicacion.CATEGORIA+") REFERENCES "+
                        DAOCategoria.NOMBRE_TABLA+"("+DAOCategoria._ID+"))");

        db.execSQL("CREATE TABLE " + DAOImagen.NOMBRE_TABLA + " ("
                + DAOImagen._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOImagen.ID + " TEXT NOT NULL,"
                + DAOImagen.ALTURA + " INTEGER NOT NULL,"
                + DAOImagen.IMAGEN + " BLOB NOT NULL,"
                + DAOImagen.APLICACION + " INTEGER NOT NULL,"
                + "UNIQUE (" + DAOImagen.ID + ")," +
                "FOREIGN KEY("+DAOImagen.APLICACION+") REFERENCES "+
                    DAOAplicacion.NOMBRE_TABLA+"("+DAOAplicacion._ID+"))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void cuentaAplicaciones(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCount= db.rawQuery("select count(*) from "+DAOAplicacion.NOMBRE_TABLA, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        System.out.println("Aplicaicones"+count);
    }

    public boolean actualizaAplicaciones(List<Aplicacion> apps){
        SQLiteDatabase db = this.getReadableDatabase();
        for(int i=0;i<apps.size();i++){
            //primero insertar las tablas de llaves foraneas
            ContentValues vcategorias=new ContentValues();
            Categoria categoria=apps.get(i).getCategoria();
            vcategorias.put(DAOCategoria.SCHEME,categoria.getScheme());
            vcategorias.put(DAOCategoria.LABEL,categoria.getLabel());
            vcategorias.put(DAOCategoria.TERM,categoria.getTerm());
            String where=DAOCategoria.ID+"=?";
            String[] wherearg={String.valueOf(categoria.getId())};
            int resultado=db.update(DAOCategoria.NOMBRE_TABLA,vcategorias,where,wherearg);
            if(resultado<=0){
                vcategorias.put(DAOCategoria.ID,categoria.getId());
                db.insert(DAOCategoria.NOMBRE_TABLA,null,vcategorias);
            }
        }
        return true;
    }

    public void cuentaCategoria(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCount= db.rawQuery("select count(*) from "+DAOCategoria.NOMBRE_TABLA, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        System.out.println("Categorias "+count);
    }

}
