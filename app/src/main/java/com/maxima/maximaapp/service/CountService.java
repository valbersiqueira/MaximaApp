package com.maxima.maximaapp.service;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.maxima.maximaapp.utils.CountListener;

public class CountService extends Service implements CountListener{

    private int count;
    private boolean ativo;
    private Controller controller = new Controller();

    public class Controller extends Binder{
        public CountListener getCount(){
            return (CountService.this);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return controller;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ativo = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startThred();
        return super.onStartCommand(intent, flags, startId);
    }


    private void startThred(){
        count = 0;
        ativo = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ativo) {
                    count++;
                    Log.d("COUNT", ""+count);
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public int getCount() {
        return count;
    }
}
