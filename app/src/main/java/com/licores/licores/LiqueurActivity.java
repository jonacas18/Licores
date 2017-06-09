package com.licores.licores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.licores.licores.Data.DataLiqueur;
import com.licores.licores.Models.Liqueur;

public class LiqueurActivity extends AppCompatActivity {

    Button create;
    ListView lista;
    DataLiqueur dataLiqueur;
    EditText type, name, size, price, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liqueur);

        showToolbar(getResources().getString(R.string.tb_createLiqueur), true);

        create = (Button) findViewById(R.id.id_btn_create);

        type = (EditText) findViewById(R.id.register_liqueur_type);
        name = (EditText) findViewById(R.id.register_liqueur_name);
        size = (EditText) findViewById(R.id.register_liqueur_size);
        price = (EditText) findViewById(R.id.register_liqueur_price);
        description = (EditText) findViewById(R.id.register_liqueur_description);

        lista = (ListView) findViewById(R.id.id_lv_mylist);
        dataLiqueur = new DataLiqueur(this);
        dataLiqueur.open();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createData();
                type.setText("");
                name.setText("");
                size.setText("");
                price.setText("");
                description.setText("");
            }
        });


    }

    private void createData(){
        Liqueur liqueur = new Liqueur();
        String tipo = type.getText().toString();
        String nombre = name.getText().toString();
        String tamaño = size.getText().toString();
        String precio = price.getText().toString();
        String descri = description.getText().toString();

        if (tipo.length()>0 && nombre.length()>0 && tamaño.length()>0 && precio.length()>0 && descri.length()>0){
            liqueur.setLiqueur_type(tipo);
            liqueur.setLiqueur_name(nombre);
            liqueur.setLiqueur_size(tamaño);
            liqueur.setLiqueur_price(precio);
            liqueur.setLiqueur_description(descri);

            dataLiqueur.create(liqueur);
            Toast.makeText(this, "Licor Creado.", Toast.LENGTH_SHORT).show();
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