package com.example.cherry.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {

    ImageView iv;
    TextView name,author,title,desc,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        iv = findViewById(R.id.imageView);
        name = findViewById(R.id.name);
        author = findViewById(R.id.author);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        date = findViewById(R.id.date);
        Picasso.with(this).load(getIntent().getStringExtra("link")).into(iv);
        name.setText(getIntent().getStringExtra("name"));
        author.setText(getIntent().getStringExtra("author"));
        title.setText(getIntent().getStringExtra("title"));
        desc.setText(getIntent().getStringExtra("desc"));
        date.setText(getIntent().getStringExtra("date"));


    }
}