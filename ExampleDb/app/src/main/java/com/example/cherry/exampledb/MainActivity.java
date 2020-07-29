package com.example.cherry.exampledb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cherry.exampledb.Rdatabase.RDatabase;
import com.example.cherry.exampledb.Rdatabase.Rtable;

public class MainActivity extends AppCompatActivity {
    EditText name,roll,number;
    RDatabase database;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        number = findViewById(R.id.number);
        rv = findViewById(R.id.rv);
        database = Room.databaseBuilder(this,RDatabase.class,"MYROOM")
                .allowMainThreadQueries().build();
    }

    public void submit(View view) {
        String n = name.getText().toString();
        String r = roll.getText().toString();
        String num = number.getText().toString();
        Rtable rtable = new Rtable();
        rtable.setName(n);
        rtable.setRoll(r);
        rtable.setNumber(num);
        database.rdao().insert(rtable);
        Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }
}