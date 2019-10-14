package com.example.estadistica;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.estadistica.Conexion.AdminSQLiteOpenHelper;

public class Tablas extends AppCompatActivity {
    Cursor c,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablas);
        edad();
    }
    public void edad(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Datos",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        c3 = BaseDeDatos.rawQuery("select COUNT(edad) from datos",null);
        c3.moveToFirst();
        double intervalo=c3.getInt(0);
        c=BaseDeDatos.rawQuery("SELECT MAX (edad) from datos",null);
        c2=BaseDeDatos.rawQuery("SELECT MIN (edad) from datos",null);
        c.moveToFirst();
        c2.moveToFirst();
        double menor=c2.getInt(0);
        double mayor= c.getInt(0);
        double A=(mayor-menor)/intervalo;
        double K=1+1.33*(Math.log(intervalo));
        double C=A/K;
        Toast.makeText(this,"A= "+A+"\nK="+K+"\nC="+C,Toast.LENGTH_LONG).show();
    }
}
