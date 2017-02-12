package com.example.ahmed.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {


    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker=(TimePicker) findViewById(R.id.timePicker);




    }


    public void Alarm(View v){


        int hour = timePicker.getHour();
        int min = timePicker.getMinute();

        AlarmManager alarm= (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this,Main2Activity.class);

        PendingIntent Pintent = PendingIntent.getActivity(this,0,intent,0);


        Calendar c = Calendar.getInstance();

        Calendar cal= new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), hour, min);

        long time = cal.getTimeInMillis();

        alarm.set(AlarmManager.RTC_WAKEUP,time,Pintent);
    }
}
