package com.example.estadistica.Fragments;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estadistica.Conexion.AdminSQLiteOpenHelper;
import com.example.estadistica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroFragment extends Fragment {
    private Button Guardar;
    private EditText nombre,edad,peso,estatura;


    public RegistroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_registro,container,false);
        Registrar(rootView);
        return rootView;
    }
    public void Registrar(View v){
        Guardar=v.findViewById(R.id.button);
        nombre=v.findViewById(R.id.editText);
        edad=v.findViewById(R.id.editText2);
        peso=v.findViewById(R.id.editText3);
        estatura=v.findViewById(R.id.editText4);
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity(),"Datos",null,1);
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
                    Toast.makeText(getActivity(),"Los datos se han guardado con exito",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getActivity(),"Uno de los campos esta vacio",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void Limpiar(){
        nombre.setText("");
        edad.setText("");
        peso.setText("");
        estatura.setText("");
    }

}
