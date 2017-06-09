package com.licores.licores.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.licores.licores.Adapters.UserAdapterSQLite;
import com.licores.licores.Data.DataUser;
import com.licores.licores.LoginActivity;
import com.licores.licores.Models.User;
import com.licores.licores.R;

import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {

    Button create, listbtn;
    ListView lista;
    DataUser dataUser;
    List<User> userList;
    UserAdapterSQLite adapterUser;
    EditText name, lastname, myuser, email, address, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        showToolbar(getResources().getString(R.string.tb_createAccount), true);

        create = (Button) findViewById(R.id.id_btn_create);
        listbtn = (Button) findViewById(R.id.id_btn_list);

        name = (EditText) findViewById(R.id.account_name);
        lastname = (EditText) findViewById(R.id.account_lastname);
        myuser = (EditText) findViewById(R.id.account_myuser);
        email = (EditText) findViewById(R.id.account_email);
        address = (EditText) findViewById(R.id.account_address);
        password = (EditText) findViewById(R.id.account_password);

        lista = (ListView) findViewById(R.id.id_lv_mylist);
        dataUser = new DataUser(this);
        dataUser.open();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createData();
                name.setText("");
                lastname.setText("");
                myuser.setText("");
                email.setText("");
                address.setText("");
                password.setText("");

            }
        });

        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userList = dataUser.findAll();
                adapterUser = new UserAdapterSQLite(getApplicationContext(), userList);
                lista.setAdapter(adapterUser);
            }
        });
    }

    private void createData(){
        User user = new User();

        String nombre = name.getText().toString();
        String apellido = lastname.getText().toString();
        String usuario = myuser.getText().toString();
        String correo = email.getText().toString();
        String direccion = address.getText().toString();
        String contraseña = password.getText().toString();

        if (nombre.length()>0 && apellido.length()>0 && usuario.length()>0 && correo.length()>0 && direccion.length()>0 && contraseña.length()>0){
            user.setName(nombre);
            user.setLastname(apellido);
            user.setMyuser(usuario);
            user.setEmail(correo);
            user.setAddress(direccion);
            user.setPassword(contraseña);
            dataUser.create(user);
            Toast.makeText(this, "Usuario Creado.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Debe ingresar todos los datos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}

