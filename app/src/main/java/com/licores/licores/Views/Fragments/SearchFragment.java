package com.licores.licores.Views.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.licores.licores.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements OnMapReadyCallback {

    View rootView;
    GoogleMap m_map;
    boolean mapReady = false;


    static final CameraPosition PASTO = CameraPosition.builder()
            .target(new LatLng(1.2089284,-77.2779443))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.3491))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478,-6.2597))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition TOKYO= CameraPosition.builder()
            .target(new LatLng(35.6895,139.6917))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_search, container, false);

        Button btnSeattle = (Button) rootView.findViewById(R.id.id_btn_seattle);
        btnSeattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flyTo(SEATTLE);
            }
        });
        Button btnDublin = (Button) rootView.findViewById(R.id.id_btn_dublin);
        btnDublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flyTo(DUBLIN);
            }
        });
        Button btnTokyo = (Button) rootView.findViewById(R.id.id_btn_tokyo);
        btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flyTo(TOKYO);
            }
        });

        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        m_map = googleMap;
    }

    public void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),1000, null);
    }
}
