package com.example.cherry.examplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.nio.file.FileVisitOption;

public class MainActivity2 extends AppCompatActivity {
        TextView tv;
        SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.name);
        preferences = getSharedPreferences("Data",MODE_PRIVATE);
        //To fetch the data from share preferences.
        tv.setText("Welcome "+preferences.getString("name",null));
    }
}