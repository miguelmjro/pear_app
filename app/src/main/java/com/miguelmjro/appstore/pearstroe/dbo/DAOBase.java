package com.miguelmjro.appstore.pearstroe.dbo;


import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

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
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + DAOArtista.NOMBRE_TABLA + " ("
                + DAOArtista._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +DAOArtista.ID + "TEXT NOT NULL,"
                + DAOArtista.NAME + " TEXT NOT NULL,"
                + DAOArtista.PAGINA + " TEXT NOT NULL,"
                + "UNIQUE (" + DAOArtista.ID + "),"
                + "UNIQUE("+ DAOArtista.PAGINA+"))");

        sqLiteDatabase.execSQL("CREATE TABLE " + DAOCategoria.NOMBRE_TABLA + " ("
                + DAOCategoria._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOCategoria.ID + "TEXT NOT NULL,"
                + DAOCategoria.LABEL + " TEXT NOT NULL,"
                + DAOCategoria.SCHEME + " TEXT NOT NULL,"
                + DAOCategoria.TERM + " TEXT NOT NULL,"
                + "UNIQUE (" + DAOCategoria.ID + "))");

        sqLiteDatabase.execSQL("CREATE TABLE " + DAOMoneda.NOMBRE_TABLA + " ("
                + DAOMoneda._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOMoneda.ID + "TEXT NOT NULL,"
                + DAOMoneda.CURRENCYCODE + " TEXT NOT NULL,"
                + "UNIQUE (" + DAOMoneda.ID + "))");

        sqLiteDatabase.execSQL("CREATE TABLE " + DAOAplicacion.NOMBRE_TABLA + " ("
                + DAOAplicacion._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOAplicacion.ID + "TEXT NOT NULL,"
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

        sqLiteDatabase.execSQL("CREATE TABLE " + DAOImagen.NOMBRE_TABLA + " ("
                + DAOImagen._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DAOImagen.ID + "TEXT NOT NULL,"
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

}
