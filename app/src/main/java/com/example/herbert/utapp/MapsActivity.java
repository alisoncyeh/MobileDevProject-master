package com.example.herbert.utapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Dictionary;
import java.util.Hashtable;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // Handle the spinner
        spinner = (Spinner) findViewById(R.id.spinnerBuildings);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.buildings,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        float zoomLevel = 16;

        // Add a marker on the UT campus
        LatLng MainBuilding = new LatLng(30.286071, -97.739368);
        mMap.addMarker(new MarkerOptions().position(MainBuilding).title("Tower"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MainBuilding, zoomLevel));
        //mMap.setMyLocationEnabled(true);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView buildingsText = (TextView) view;
        ///Toast.makeText(MapsActivity.this, buildingsText.getText(), Toast.LENGTH_SHORT).show();
        float zoomLevel = 17;
        float tiltLevel = 20;


        //Latitudes of buildings

        LatLng RLM = new LatLng(30.289033, -97.736326);
        LatLng WEL = new LatLng(30.286549, -97.737723);
        LatLng GRE = new LatLng(30.284077, -97.736550);
        LatLng MAI = new LatLng(30.286071, -97.739368);


        ///Creating hash table
        /***Dictionary dict = new Hashtable();

        //adding elements to hash table
        ///dict.put("RLM",new LatLng(30.289033, -97.736326));
        dict.put("RLM",RLM);

        String newString = buildingsText.getText().toString();

        ///MarkerOptions userIndicator = new MarkerOptions()
                ///.position(dict.get(newString));

        ///TRYING TO GET OUT OF A BOOLEAN
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(RLM).title("Marker on the Tower"));
        ///mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RLM, zoomLevel));
        mMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(
                        new CameraPosition.Builder()
                                .target(dict.get(newString))
                                .zoom(zoomLevel)
                                .bearing(0)
                                .tilt(tiltLevel)
                                .build()));

         ***/



        ///RLM selected by building
        if (buildingsText.getText().toString().equals("RLM")){
            Toast.makeText(MapsActivity.this, buildingsText.getText(), Toast.LENGTH_SHORT).show();
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(RLM).title("RLM"));
            ///mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RLM, zoomLevel));
            mMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(
                            new CameraPosition.Builder()
                                    .target(RLM)
                                    .zoom(zoomLevel)
                                    .bearing(0)
                                    .tilt(tiltLevel)
                                    .build()));
        }

        /// Welch selected
        else if (buildingsText.getText().toString().equals("Welch Hall")){
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(WEL).title("Welch"));
            ///mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WEL, zoomLevel));
            mMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(
                            new CameraPosition.Builder()
                                    .target(WEL)
                                    .zoom(zoomLevel)
                                    .bearing(0)
                                    .tilt(tiltLevel)
                                    .build()));
        }

        // Gregory gym selected
        else if (buildingsText.getText().toString().equals("Gregory Gym")){
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(GRE).title("Gregory Gym"));
            ///mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GRE, zoomLevel));
            mMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(
                            new CameraPosition.Builder()
                                    .target(GRE)
                                    .zoom(zoomLevel)
                                    .bearing(0)
                                    .tilt(tiltLevel)
                                    .build()));
        }

        // Main building selected
        else if (buildingsText.getText().toString().equals("Main Building")){
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(MAI).title("Tower"));
            ///mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MAI, zoomLevel));
            mMap.animateCamera(
                    CameraUpdateFactory.newCameraPosition(
                            new CameraPosition.Builder()
                                    .target(MAI)
                                    .zoom(zoomLevel)
                                    .bearing(0)
                                    .tilt(tiltLevel)
                                    .build()));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Nothing implemented if the user doesn't use the spinner
    }
}
