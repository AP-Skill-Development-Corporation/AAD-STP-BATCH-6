package com.example.cherry.examplework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    OneTimeWorkRequest firstrequest,secondrequest;
    PeriodicWorkRequest thirdrequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstrequest = new OneTimeWorkRequest
                .Builder(FirstWork.class)
                .build();
        Constraints constraints = new Constraints
                .Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        secondrequest = new OneTimeWorkRequest.
                Builder(SecondWork.class)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .setConstraints(constraints)
                .build();
        thirdrequest = new PeriodicWorkRequest.Builder(ThirdWork.class,15
                ,TimeUnit.MINUTES).build();
    }

    public void dowork(View view) {
        WorkManager.getInstance(this).beginWith(firstrequest).
                then(secondrequest).enqueue();
        WorkManager.getInstance(this).enqueue(thirdrequest);
       // WorkManager.getInstance(this).enqueue(secondrequest);
    }
}