package com.example.cherry.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;//Declare it globally
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate the view inside onCreate method
        tv = findViewById(R.id.textv);
    }
    public void count(View view) {
        i++;
        tv.setText(""+i);
        //tv.setText(String.valueOf(i));

    }
    public void toast(View view) {
        Toast.makeText(this, "Welcome to Android", Toast.LENGTH_SHORT).show();
    }

}