package com.example.bataa.quecocino;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.R;
import android.R.*;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

 public class principal extends AppCompatActivity {
    private EditText et1;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        et1=(EditText)findViewById(R.id.editText);
       siguiente = (Button)findViewById(R.id.button);

        siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent siguiene = new Intent(principal.this,ingredientes.class);
                startActivity(siguiene);
            }
        });
    }
    public void buscar (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        bd.insert("articulos", null, registro);
        bd.close();
        et1.setText("");

        Toast.makeText(this, "Se cargaron los datos del artículo",Toast.LENGTH_SHORT).show();
    }
}