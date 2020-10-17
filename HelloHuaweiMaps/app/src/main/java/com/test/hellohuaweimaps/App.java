package com.test.hellohuaweimaps;

import android.app.Application;
import android.graphics.Typeface;

public class App extends Application {

    private static Typeface typeface;

    @Override
    public void onCreate() {
        super.onCreate();
        typeface = Typeface.createFromAsset(getAssets(), "fonts/webfont.ttf");
    }

    public static Typeface getTypeface() {
        return typeface;
    }
}
