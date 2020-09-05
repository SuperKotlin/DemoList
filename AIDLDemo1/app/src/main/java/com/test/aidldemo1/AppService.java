package com.test.aidldemo1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AppService extends Service {


    private String myData = "default data";
    private boolean status = true;

    public AppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new IMyAidlInterface.Stub() {

            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void setData(String data) throws RemoteException {
                myData = data;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("zhuyong app", "Service onCreate...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (status) {
                    Log.e("zhuyong app", "myData...: " + myData);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("zhuyong app", "Service onDestroy...");
        status = false;
    }
}
