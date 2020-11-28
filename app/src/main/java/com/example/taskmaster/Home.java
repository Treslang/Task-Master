package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    public ImageButton profile;
    public ImageButton daily;
    public ImageButton weekly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    profile = (ImageButton)findViewById(R.id.imageButton);
    profile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openProfileActivity();
        }
    });


    weekly = (ImageButton) findViewById(R.id.imageButton3);
    weekly.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openWeeklyActivity();
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

    public  void openWeeklyActivity(){
        Intent weekly = new Intent(this, ViewTasks.class);
        startActivity(weekly);
    }

    public void openProfileActivity(){
        Intent profile = new Intent(this, Profile.class);
        startActivity(profile);
    }
}