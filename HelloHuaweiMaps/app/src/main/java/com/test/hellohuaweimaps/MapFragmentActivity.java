package com.test.hellohuaweimaps;

import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;

import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.StreetViewPanoramaOptions;
import com.huawei.hms.maps.StreetViewPanoramaView;
import com.huawei.hms.maps.model.LatLng;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MapFragmentActivity extends AppCompatActivity implements OnMapReadyCallback {

    private HuaweiMap hMap;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapfragment);
        StreetViewPanoramaOptions options = new StreetViewPanoramaOptions();
        options.position(new LatLng(43, 2), 5);
        StreetViewPanoramaView streetViewPanoramaView = new StreetViewPanoramaView(this, options);

        addContentView(streetViewPanoramaView,
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        streetViewPanoramaView.onCreate(null);
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        hMap = huaweiMap;
        hMap.getUiSettings().setZoomControlsEnabled(false);
    }

}
