package com.example.a30797.androidtest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Button mStart;
    private Button mStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStart = (Button) findViewById(R.id.start);
        mStop = (Button) findViewById(R.id.stop);

        final Intent intent = new Intent(MainActivity.this, ChangeService.class);
         final PendingIntent pi = PendingIntent.getService(MainActivity.this, 0, intent, 0);
         mStart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
                 alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, 6000, pi);
                 mStart.setEnabled(false); mStop.setEnabled(true);
                 Toast.makeText(MainActivity.this, "昊天壁纸更换系统启动", Toast.LENGTH_SHORT).show();
             }
         });
         mStop.setOnClickListener(new View.OnClickListener() {
             @Override public void onClick(View v) {
                 mStart.setEnabled(true);
                 mStop.setEnabled(false);
                 AlarmManager alarmManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
                 alarmManager.cancel(pi);
                 Toast.makeText(MainActivity.this, "昊天壁纸更换系统启动", Toast.LENGTH_SHORT).show();
             }
         });
    }
}


