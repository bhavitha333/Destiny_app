package com.example.destinyminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {




    Timer timer;
    SharedPreferences sharedPreferences;
    String themeName;




    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        getTheme().applyStyle(R.style.ThemeDark, false);



        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 5);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,MainActivity1.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }



}