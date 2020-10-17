package com.test.hellohuaweimaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSecond(View view) {
        MyModel myModel = new MyModel();
        myModel.setAnInt(1);
        myModel.setaIntegerObject(2);
        myModel.setaFloat(3f);
        myModel.setaFloatObject(4f);
        myModel.setaDoubke(5.0);
        myModel.setaDoubleObject(6.0);
        startActivity(new Intent(this, SecondActivity.class)
                .putExtra("name", myModel));
    }

}
