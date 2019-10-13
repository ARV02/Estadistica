package com.example.estadistica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.estadistica.Fragments.GraficasFragment;
import com.example.estadistica.Fragments.MedidasFragment;
import com.example.estadistica.Fragments.RegistroFragment;
import com.example.estadistica.Fragments.TablasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationView=findViewById(R.id.nav_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menu_registro){
                    showSelectedFragment(new RegistroFragment());
                }if (menuItem.getItemId() == R.id.menu_tablas){
                    showSelectedFragment(new TablasFragment());
                }if(menuItem.getItemId() == R.id.menu_graficas){
                    showSelectedFragment(new GraficasFragment());
                }if (menuItem.getItemId() == R.id.menu_medidas){
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
