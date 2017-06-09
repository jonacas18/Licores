package com.licores.licores.Views.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.licores.licores.Adapters.AdapterLiqueur;
import com.licores.licores.Data.DataLiqueur;
import com.licores.licores.LiqueurActivity;
import com.licores.licores.Models.Liqueur;
import com.licores.licores.R;

import java.util.List;

public class HomeFragment extends Fragment {

    View rootView;
    FloatingActionButton button;
    ListView lista;
    DataLiqueur dataLiqueur;
    List<Liqueur> liqueursList;
    AdapterLiqueur adapterLiqueur;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        lista = (ListView) rootView.findViewById(R.id.id_lv_mylist);
        liqueur();

        button = (FloatingActionButton) rootView.findViewById(R.id.btn_plus_math);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LiqueurActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    public void liqueur() {
        dataLiqueur = new DataLiqueur(getActivity());
        dataLiqueur.open();

        liqueursList = dataLiqueur.findAll();
        adapterLiqueur = new AdapterLiqueur(getContext(), liqueursList);
        lista.setAdapter(adapterLiqueur);
    }

}
