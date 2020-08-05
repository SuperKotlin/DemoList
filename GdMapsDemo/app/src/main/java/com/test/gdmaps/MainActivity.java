package com.test.gdmaps;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AMap aMap;
    private MapView mMapView = null;

    private EditText southwest_lat;
    private EditText southwest_lng;
    private EditText northeast_lat;
    private EditText northeast_lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        southwest_lat = findViewById(R.id.southwest_lat);
        southwest_lng = findViewById(R.id.southwest_lng);
        northeast_lat = findViewById(R.id.northeast_lat);
        northeast_lng = findViewById(R.id.northeast_lng);

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        aMap = mMapView.getMap();

        aMap.getUiSettings().setCompassEnabled(true);
    }

    public void setLatLngBounds(View view) {
        try {
            aMap.clear();

            String southwestLat = southwest_lat.getText().toString().trim();
            String southwestLng = southwest_lng.getText().toString().trim();
            String northeastLat = northeast_lat.getText().toString().trim();
            String northeastLng = northeast_lng.getText().toString().trim();

            if (TextUtils.isEmpty(southwestLat) || TextUtils.isEmpty(southwestLng)) {
                southwest_lat.setText("31.259770");
                southwest_lng.setText("118.454590");
            }

            if (TextUtils.isEmpty(northeastLat) || TextUtils.isEmpty(northeastLng)) {
                northeast_lat.setText("32.491230");
                northeast_lng.setText("120.410156");
            }

            southwestLat = southwest_lat.getText().toString().trim();
            southwestLng = southwest_lng.getText().toString().trim();
            northeastLat = northeast_lat.getText().toString().trim();
            northeastLng = northeast_lng.getText().toString().trim();

            LatLng southwestLatLng = new LatLng(Double.parseDouble(southwestLat), Double.parseDouble(southwestLng));
            LatLng northeastLatLng = new LatLng(Double.parseDouble(northeastLat), Double.parseDouble(northeastLng));

            aMap.addMarker(new MarkerOptions().position(southwestLatLng)
                    .title("southwestLatLng")
                    .snippet("southwestLatLng")
                    .icon(BitmapDescriptorFactory.defaultMarker()));

            aMap.addMarker(new MarkerOptions().position(northeastLatLng)
                    .title("northeastLatLng")
                    .snippet("northeastLatLng")
                    .icon(BitmapDescriptorFactory.defaultMarker()));

            aMap.addCircle(new CircleOptions().center(southwestLatLng).fillColor(Color.RED).strokeColor(Color.RED).radius(3510));
            aMap.addCircle(new CircleOptions().center(northeastLatLng).fillColor(Color.RED).strokeColor(Color.RED).radius(3510));

            LatLngBounds latLngBounds = new LatLngBounds(southwestLatLng, northeastLatLng);
            aMap.setMapStatusLimits(latLngBounds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear(View view) {
        aMap.setMapStatusLimits(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
}