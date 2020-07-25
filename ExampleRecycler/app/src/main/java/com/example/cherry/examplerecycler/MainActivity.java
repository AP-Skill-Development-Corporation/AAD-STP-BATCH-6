package com.example.cherry.examplerecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    String[] names = {"Alpha","Beta","CupCake","Donut","Eclairs",
    "Froyo","Gingerbread","Honeycomb","Icecream","Jellybean",
    "Kitkat","Lollipop","Marshmallow","Nougat","Oreo","Pie","Queen"};
    int images[] = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut,
    R.drawable.eclairs,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,
    R.drawable.icecream,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,
    R.drawable.marsh,R.drawable.nougat,R.drawable.oreo,R.drawable.pie,R.drawable.q};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        MyAdapter adapter = new MyAdapter(this,names,images);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}