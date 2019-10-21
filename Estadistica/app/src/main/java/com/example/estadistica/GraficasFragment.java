package com.example.estadistica;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;


/**
 * A simple {@link Fragment} subclass.
 */
public class GraficasFragment extends Fragment {
    private LineChart lineChart;


    public GraficasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_graficas, container, false);
        Tablas(rootView);
        return rootView;
    }
    public void Tablas(View v){
        lineChart=v.findViewById(R.id.LineChart);
    }

}
