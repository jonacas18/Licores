package com.licores.licores.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.licores.licores.Helpers.HelperUser;
import com.licores.licores.Models.User;

import java.util.ArrayList;
import java.util.List;

public class DataUser {
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            HelperUser.COLUMN_ID,
            HelperUser.COLUMN_NAME,
            HelperUser.COLUMN_LASTNAME,
            HelperUser.COLUMN_MYUSER,
            HelperUser.COLUMN_EMAIL,
            HelperUser.COLUMN_ADDRESS,
            HelperUser.COLUMN_PASSWORD
    };

    public DataUser(Context context){
        dbHelper = new HelperUser(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public User create(User user){
        ContentValues values = new ContentValues();
        values.put(HelperUser.COLUMN_NAME, user.getName());
        values.put(HelperUser.COLUMN_LASTNAME, user.getLastname());
        values.put(HelperUser.COLUMN_MYUSER, user.getMyuser());
        values.put(HelperUser.COLUMN_EMAIL, user.getEmail());
        values.put(HelperUser.COLUMN_ADDRESS, user.getAddress());
        values.put(HelperUser.COLUMN_PASSWORD, user.getPassword());

        long insertId = database.insert(HelperUser.TABLE_USERS, null, values);

        user.setId(insertId);

        return user;
    }

    public List<User> cursorToList(Cursor cursor){
        List<User> users = new ArrayList<>();
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                User user = new User();
                user.setId(cursor.getLong(cursor.getColumnIndex(HelperUser.COLUMN_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(HelperUser.COLUMN_NAME)));
                user.setLastname(cursor.getString(cursor.getColumnIndex(HelperUser.COLUMN_LASTNAME)));
                user.setMyuser(cursor.getString(cursor.getColumnIndex(HelperUser.COLUMN_MYUSER)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(HelperUser.COLUMN_EMAIL)));
                user.setAddress(cursor.getString(cursor.getColumnIndex(HelperUser.COLUMN_ADDRESS)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(HelperUser.COLUMN_PASSWORD)));

                users.add(user);
            }
        }
        return users;
    }

    public List<User> findAll(){
        Cursor cursor = database.rawQuery("select id,name,lastname,myuser,email,address,password from users", null);
        List<User> users = cursorToList(cursor);
        return users;
    }
}