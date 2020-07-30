package com.example.cherry.exampledb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cherry.exampledb.Rdatabase.MyViewModel;
import com.example.cherry.exampledb.Rdatabase.RDatabase;
import com.example.cherry.exampledb.Rdatabase.Rtable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,roll,number;
    /*RDatabase database;*/
    public static MyViewModel viewModel;
    RecyclerView rv;
    //List<Rtable> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        number = findViewById(R.id.number);
        rv = findViewById(R.id.rv);
        /*database = Room.databaseBuilder(this,RDatabase.class,"MYROOM")
                .allowMainThreadQueries().build();
        list = database.rdao().getall();*/
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        /*This is to fetch the live data from the room database*/
        viewModel.readData().observe(this, new Observer<List<Rtable>>() {
            @Override
            public void onChanged(List<Rtable> rtables) {
                MyAdapter adapter = new MyAdapter(MainActivity.this, rtables);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }
    public void submit(View view) {
        String n = name.getText().toString();
        String r = roll.getText().toString();
        String num = number.getText().toString();
        Rtable rtable = new Rtable();
        rtable.setName(n);
        rtable.setRoll(r);
        rtable.setNumber(num);
        viewModel.insert(rtable);
        Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }
}