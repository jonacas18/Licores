package com.licores.licores.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.licores.licores.Helpers.HelperLiqueur;
import com.licores.licores.Models.Liqueur;

import java.util.ArrayList;
import java.util.List;

public class DataLiqueur {

    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            HelperLiqueur.COLUMN_LIQUEUR_ID,
            HelperLiqueur.COLUMN_LIQUEUR_TYPE,
            HelperLiqueur.COLUMN_LIQUEUR_NAME,
            HelperLiqueur.COLUMN_LIQUEUR_SIZE,
            HelperLiqueur.COLUMN_LIQUEUR_PRICE,
            HelperLiqueur.COLUMN_LIQUEUR_DESCRIPTION,
    };

    public DataLiqueur (Context context){
        dbHelper = new HelperLiqueur(context);
    }



    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Liqueur create(Liqueur liqueur){
        ContentValues values = new ContentValues();
        values.put(HelperLiqueur.COLUMN_LIQUEUR_TYPE, liqueur.getLiqueur_type());
        values.put(HelperLiqueur.COLUMN_LIQUEUR_NAME, liqueur.getLiqueur_name());
        values.put(HelperLiqueur.COLUMN_LIQUEUR_SIZE, liqueur.getLiqueur_size());
        values.put(HelperLiqueur.COLUMN_LIQUEUR_PRICE, liqueur.getLiqueur_price());
        values.put(HelperLiqueur.COLUMN_LIQUEUR_DESCRIPTION, liqueur.getLiqueur_description());

        long insertId = database.insert(HelperLiqueur.TABLE_LIQUEUR, null, values);

        liqueur.setLiqueur_id(insertId);

        return liqueur;
    }

    public List<Liqueur> cursorToList(Cursor cursor){
        List<Liqueur> liqueurs = new ArrayList<>();
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Liqueur liqueur = new Liqueur();
                liqueur.setLiqueur_id(cursor.getLong(cursor.getColumnIndex(HelperLiqueur.COLUMN_LIQUEUR_ID)));
                liqueur.setLiqueur_type(cursor.getString(cursor.getColumnIndex(HelperLiqueur.COLUMN_LIQUEUR_TYPE)));
                liqueur.setLiqueur_name(cursor.getString(cursor.getColumnIndex(HelperLiqueur.COLUMN_LIQUEUR_NAME)));
                liqueur.setLiqueur_size(cursor.getString(cursor.getColumnIndex(HelperLiqueur.COLUMN_LIQUEUR_SIZE)));
                liqueur.setLiqueur_price(cursor.getString(cursor.getColumnIndex(HelperLiqueur.COLUMN_LIQUEUR_PRICE)));
                liqueur.setLiqueur_description(cursor.getString(cursor.getColumnIndex(HelperLiqueur.COLUMN_LIQUEUR_DESCRIPTION)));

                liqueurs.add(liqueur);
            }
        }
        return liqueurs;
    }

    public List<Liqueur> findAll(){
        Cursor cursor = database.rawQuery("select liqueur_id,liqueur_type,liqueur_name,liqueur_size,liqueur_price,liqueur_description from liqueur", null);
        List<Liqueur> liqueurs = cursorToList(cursor);
        return liqueurs;
    }

}

