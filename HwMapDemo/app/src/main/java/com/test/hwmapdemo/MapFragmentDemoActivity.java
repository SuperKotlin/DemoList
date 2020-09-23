package com.test.hwmapdemo;

import android.os.Bundle;
import android.util.Log;

import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.SupportMapFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MapFragmentDemoActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "MainActivity";

    private HuaweiMap hMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapfragment);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapfragmentdemo);
        supportMapFragment.getMapAsync(this);
    }

    public void onMapReady(HuaweiMap map) {
        Log.d(TAG, "onMapReady: ");
        hMap = map;

        hMap.getUiSettings().setMyLocationButtonEnabled(true);
        hMap.setMyLocationEnabled(true);
    }

}
