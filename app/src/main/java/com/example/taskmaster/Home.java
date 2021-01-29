package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    public ImageButton profile;
    public ImageButton daily;
    public ImageButton remind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        createNotificationChannel();

    profile = (ImageButton)findViewById(R.id.imageButton);
    profile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openProfileActivity();
        }
    });
        remind = (ImageButton) findViewById(R.id.imageButton3);
        remind.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Toast.makeText(Home.this, "Reminder Set", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Home.this,ReminderBroadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(Home.this, 0, intent, 0);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            long timeAtButtonClick = System.currentTimeMillis();
            long tenSecondsInMillis = 1000 * 10;

            alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSecondsInMillis, pendingIntent);

        }


    });






    daily = (ImageButton) findViewById(R.id.imageButton2);
    daily.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        openDailyActivity();

        }
    });

    }
    public void openDailyActivity(){
        Intent daily = new Intent(this, Daily.class);
        startActivity(daily);
    }



    public void openProfileActivity(){
        Intent profile = new Intent(this, Profile.class);
        startActivity(profile);
    }

    private void createNotificationChannel(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1){
            CharSequence name = "LemubitReminderChannel";
            String description = "Channel for Lemubit Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLemubit" , name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}