package com.example.estadistica;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.estadistica.Conexion.AdminSQLiteOpenHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class TablaFragment extends Fragment {
    private Cursor c,c2,c3;


    public TablaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_tabla,container,false);
        edad(rootView);
        return rootView;
    }
    public void edad(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity(),"Datos",null,1);
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
        Toast.makeText(getActivity(),"A= "+A+"\nK="+K+"\nC="+C,Toast.LENGTH_LONG).show();
    }
}
