package com.example.cherry.registartion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et,et1,et2;
    Spinner sp;
    RadioGroup rg;
    RadioButton rb;
    CheckBox cb1,cb2,cb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.name);
        et1 = findViewById(R.id.email);
        et2 = findViewById(R.id.number);
        sp = findViewById(R.id.branch);
        rg = findViewById(R.id.rg);
        cb1 = findViewById(R.id.tel);
        cb2 = findViewById(R.id.hin);
        cb3 = findViewById(R.id.eng);
    }

    public void register(View view) {
        String name = et.getText().toString();
        String email = et1.getText().toString();
        String number = et2.getText().toString();
        String branch = sp.getSelectedItem().toString();
        int i = rg.getCheckedRadioButtonId();
        rb = findViewById(i);
        StringBuilder sb = new StringBuilder();
        if (cb1.isChecked()){
            sb.append("Telugu"+"\n");
        }
        if (cb2.isChecked()){
            sb.append("Hindi"+"\n");
        }
        if (cb3.isChecked()){
            sb.append("English");
        }
        String lang = sb.toString();
        Toast.makeText(this, ""+name+"\n"+email+"\n"+number
                +"\n"+branch+"\n"+rb.getText()+"\n"+lang, Toast.LENGTH_SHORT).show();
    }
}