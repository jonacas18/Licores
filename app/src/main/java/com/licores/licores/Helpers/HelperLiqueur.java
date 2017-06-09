package com.licores.licores.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HelperLiqueur extends SQLiteOpenHelper {

    private static final String LOGTAG = "LOGTAG";
    private static final String DATABASE_NAME = "liqueur";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_LIQUEUR = "liqueur";
    public static final String COLUMN_LIQUEUR_ID = "liqueur_id";
    public static final String COLUMN_LIQUEUR_TYPE = "liqueur_type";
    public static final String COLUMN_LIQUEUR_NAME = "liqueur_name";
    public static final String COLUMN_LIQUEUR_SIZE = "liqueur_size";
    public static final String COLUMN_LIQUEUR_PRICE = "liqueur_price";
    public static final String COLUMN_LIQUEUR_DESCRIPTION = "liqueur_description";


    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_LIQUEUR + " (" +
                    COLUMN_LIQUEUR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_LIQUEUR_TYPE + " TEXT, " +
                    COLUMN_LIQUEUR_NAME + " TEXT, " +
                    COLUMN_LIQUEUR_SIZE + " TEXT," +
                    COLUMN_LIQUEUR_PRICE + " TEXT, " +
                    COLUMN_LIQUEUR_DESCRIPTION + " TEXT " +
                    ")";

    public HelperLiqueur (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_CREATE);
        Log.i(LOGTAG, "Tabla de licores creada correctamente.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXIST "+TABLE_LIQUEUR);
        onCreate(database);
    }
}