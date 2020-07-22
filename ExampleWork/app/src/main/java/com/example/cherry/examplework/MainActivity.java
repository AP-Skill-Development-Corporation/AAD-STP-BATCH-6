package com.example.cherry.examplework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    OneTimeWorkRequest firstrequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstrequest = new OneTimeWorkRequest.Builder(FirstWork.class).build();
    }

    public void dowork(View view) {
        WorkManager.getInstance(this).enqueue(firstrequest);
    }
}