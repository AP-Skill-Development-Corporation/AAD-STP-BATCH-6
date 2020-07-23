package com.example.cherry.examplenotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    public void notify(View view) {
        createNotification();
        sendNotification();
    }
    private void sendNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this,"Demo");
        builder.setContentTitle("Notification");
        builder.setContentText("This is my notification");
        builder.setSmallIcon(R.drawable.ic_notify);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        //builder.addAction(R.drawable.ic_notify,"Reply",)
        manager.notify(0,builder.build());

    }
    private void createNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Demo","chaitu",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.enableVibration(true);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            manager.createNotificationChannel(channel);
        }
    }
}