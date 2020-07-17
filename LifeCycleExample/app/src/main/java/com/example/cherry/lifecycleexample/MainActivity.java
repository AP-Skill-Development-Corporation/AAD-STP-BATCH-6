package com.example.cherry.lifecycleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Chaitu","Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Chaitu","Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Chaitu","Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Chaitu","Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Chaitu","Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Chaitu","Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Chaitu","Destroy");
    }

    public void next(View view) {
        startActivity(new Intent(this,MainActivity2.class));
    }
}