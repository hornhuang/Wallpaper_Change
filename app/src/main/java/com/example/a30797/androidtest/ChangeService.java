package com.example.a30797.androidtest;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class ChangeService extends Service {
    int[] wallpapers = new int[]{
            R.drawable.a1,R.drawable.a2, R.drawable.a3, R.drawable.a4 ,R.drawable.a5,
            R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a10,
            R.drawable.a11,R.drawable.a13,R.drawable.a15,
            R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,
            R.drawable.a21,R.drawable.a22,R.drawable.a23,R.drawable.a24,R.drawable.a25,
            R.drawable.a27,R.drawable.a28,R.drawable.a29,R.drawable.a30,
            R.drawable.a31,R.drawable.a32,R.drawable.a33,R.drawable.a34,R.drawable.a35,
            R.drawable.a36
    };
    WallpaperManager wallpaperManager;
    int current = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        wallpaperManager = WallpaperManager.getInstance(this);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (current >= 3) {
            current = 0;
        } try {
            wallpaperManager.setResource(wallpapers[current++]);
        } catch (IOException e) {
            e.printStackTrace();
        } return START_STICKY;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

