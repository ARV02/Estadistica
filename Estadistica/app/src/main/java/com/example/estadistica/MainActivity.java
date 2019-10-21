package com.example.estadistica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    Intent inte;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView=findViewById(R.id.nav_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menu_registro){
                    //inte=new Intent(mBottomNavigationView.getContext(),Regis.class);
                    //startActivity(inte);
                    showSelectedFragment(new RegistroFragment());
                }else if (menuItem.getItemId() == R.id.menu_tablas){
                    //inte=new Intent(mBottomNavigationView.getContext(),Tablas.class);
                    //startActivity(inte);
                    showSelectedFragment(new TablaFragment());
                }else if(menuItem.getItemId() == R.id.menu_graficas){
                   // inte = new Intent(mBottomNavigationView.getContext(), Graficas.class);
                    //startActivity(inte);
                    //showSelectedFragment(new GraficasFragment());
                }else if (menuItem.getItemId() == R.id.menu_medidas){
                    //inte = new Intent(mBottomNavigationView.getContext(),Medidas.class);
                    //startActivity(inte);
                    showSelectedFragment(new MedidasFragment());
                }
                return true;
            }
        });
    }
    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
