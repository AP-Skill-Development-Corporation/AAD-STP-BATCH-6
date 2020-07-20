package com.example.cherry.menusexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        registerForContextMenu(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.call:
                tv.setText("call");
                break;
            case R.id.chat:
                tv.setText("chat");
                break;
            case R.id.status:
                tv.setText(item.getTitle());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mymenu,menu);
        menu.setHeaderTitle("Select");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.chat :
               Toast.makeText(this, "Chatted", Toast.LENGTH_SHORT).show();
               break;
           case R.id.status:
               Toast.makeText(this, "Status", Toast.LENGTH_SHORT).show();
               break;
       }
        return super.onContextItemSelected(item);
    }
}