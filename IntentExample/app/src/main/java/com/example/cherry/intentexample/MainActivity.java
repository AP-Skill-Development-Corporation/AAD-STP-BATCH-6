package com.example.cherry.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et,et1,et2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.name);
        et1 = findViewById(R.id.link);
        et2 = findViewById(R.id.number);
        b = findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et.getText().toString();
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("key",name);
                startActivity(i);
            }
        });
    }
    public void search(View view) {
        String link = et1.getText().toString();
        Uri uri=Uri.parse("https://"+link);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);

    }

    public void call(View view) {
        String  number = et2.getText().toString();
        Uri uri=Uri.parse("tel:"+number);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }
}