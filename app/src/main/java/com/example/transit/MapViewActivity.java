package com.example.transit;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;

public class MapViewActivity extends AppCompatActivity {
    MapViewActivity mapViewActivity;
    Mapbox mapbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this,"pk.eyJ1IjoiYmVsZ2FjZW1haGxlbSIsImEiOiJja2E4enZqZHYwMWJkMnJydTRqMzQ0cXY1In0.pr7u_MjK5kIZkcRD9Zauzw");
        setContentView(R.layout.activity_map_view);
        mapViewActivity= (MapViewActivity) findViewById(R.id.map1);


        mapViewActivity.getMapAsync(new onMapReadyCallback(){
            @Override
            public void  onMapReady(Mapbox mapbox){
                MarkerOptions options= new MarkerOptions();
                options.title("Position Actuel");
                options.title(String.valueOf(new LatLng(34.74,10.765)));
                mapbox.addMaker (options);
            }
        });
    }

    private void getMapAsync(onMapReadyCallback onMapReadyCallback) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapViewActivity.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapViewActivity.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapViewActivity.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapViewActivity.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapViewActivity.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapViewActivity.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapViewActivity.onSaveInstanceState(outState);
    }

    private class onMapReadyCallback {
    }
}
