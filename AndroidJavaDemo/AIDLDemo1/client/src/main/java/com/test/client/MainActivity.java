package com.test.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.test.aidldemo1.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent();
        intent.setComponent(new ComponentName("com.test.aidldemo1", "com.test.aidldemo1.AppService"));
    }

    public void bindService(View view) {
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    public void unBindService(View view) {
        unbindService(this);
        myAidlInterface = null;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.e("zhuyong client", "onServiceConnected...  ComponentName:" + name);
        myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.e("zhuyong client", "onServiceDisconnected...");
    }


    private IMyAidlInterface myAidlInterface;

    public void setData(View view) {
        if (myAidlInterface != null) {
            try {
                myAidlInterface.setData("数据通信的DATA");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
