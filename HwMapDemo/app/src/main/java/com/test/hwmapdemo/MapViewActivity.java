package com.test.hwmapdemo;

import android.os.Bundle;
import android.util.Log;

import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MarkerOptions;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MapViewActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "MainActivity";
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private MapView mMapView;
    private HuaweiMap hMap;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapview);

        mMapView = findViewById(R.id.mapview_mapviewdemo);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle("MapViewBundleKey");
        }
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
    }

    public void onMapReady(HuaweiMap map) {
        Log.d(TAG, "onMapReady: ");
        hMap = map;

        hMap.getUiSettings().setMyLocationButtonEnabled(true);
        hMap.setMyLocationEnabled(true);
    }

    private void addMarker() {
        int maxLat = 90;
        int maxLng = 180;

        for (int i = 0; i < 100; i++) {

            int lat = random.nextInt(maxLat) % (maxLat + maxLat + 1) - maxLat;
            int lng = random.nextInt(maxLng) % (maxLng + maxLng + 1) - maxLng;

            LatLng latLng1 = new LatLng(lat, lng);
            hMap.addMarker(new MarkerOptions().position(latLng1).clusterable(true));
        }

        hMap.setMarkersClustering(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
