package com.licores.licores;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.licores.licores.Data.DataUser;
import com.licores.licores.Helpers.HelperUser;
import com.licores.licores.Views.ContainerActivity;
import com.licores.licores.Views.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {


    SQLiteOpenHelper dbhelper;
    SQLiteDatabase db;
    Cursor cursor;
    DataUser dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText nameLogin = (EditText) findViewById(R.id.txt_username);
        final EditText passworLogin = (EditText) findViewById(R.id.txt_password);
        Button btnlogin = (Button) findViewById(R.id.btn_login);

        dbhelper = new HelperUser(this);
        db = dbhelper.getReadableDatabase();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = nameLogin.getText().toString();
                String password = passworLogin.getText().toString();

                cursor = db.rawQuery("SELECT *FROM "+ HelperUser.TABLE_USERS+" WHERE "+HelperUser.COLUMN_MYUSER+"=? AND "+HelperUser.COLUMN_PASSWORD+"=?",new String[] {user,password});
                if (cursor != null) {
                    if(cursor.getCount() > 0) {

                        cursor.moveToFirst();

                        Toast.makeText(LoginActivity.this, "Bienvenido "+user,  Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,ContainerActivity.class);
                        startActivity(intent);

                        finish();
                    }
                    else {

                        Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecto. ",  Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }


}