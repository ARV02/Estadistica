package com.example.estadistica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estadistica.Conexion.AdminSQLiteOpenHelper;

public class Regis extends AppCompatActivity {
    private TextView nombre,edad,peso,estatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        nombre=findViewById(R.id.editText);
        edad=findViewById(R.id.editText2);
        peso=findViewById(R.id.editText3);
        estatura=findViewById(R.id.editText4);
    }
    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Datos",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String nom=nombre.getText().toString();
        String ed=edad.getText().toString();
        String pes=peso.getText().toString();
        String est=estatura.getText().toString();
        if(!nom.isEmpty() && !ed.isEmpty() && !pes.isEmpty() && !est.isEmpty()){
            ContentValues regis = new ContentValues();
            regis.put("nombre",nom);
            regis.put("edad",ed);
            regis.put("peso",pes);
            regis.put("estatura",est);
            BaseDeDatos.insert("datos",null,regis);
            Limpiar();
            BaseDeDatos.close();
            Toast.makeText(this,"Los datos se han guardado con exito",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Uno de los campos esta vacio",Toast.LENGTH_LONG).show();
        }
    }
    public void Limpiar(){
        nombre.setText("");
        edad.setText("");
        peso.setText("");
        estatura.setText("");
    }
}
