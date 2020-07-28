package com.example.cherry.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Policy;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Retrofit retrofit;
    MyInterface myInterface;
    ArrayList<Pojo> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        list = new ArrayList<>();
        retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/v2/").
                addConverterFactory(ScalarsConverterFactory.create()).build();
        myInterface = retrofit.create(MyInterface.class);
        Call<String> response = myInterface.value();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this,
                        ""+response.body(), Toast.LENGTH_SHORT).show();
                String r = response.body();
                try {
                    JSONObject root = new JSONObject(r);
                    JSONArray articles = root.getJSONArray("articles");
                    for (int i = 0;i<articles.length();i++){
                    JSONObject object =articles.getJSONObject(i);
                    JSONObject source = object.getJSONObject("source");
                    String name = source.getString("name");
                    String author = object.getString("author");
                    String title = object.getString("title");
                    String desc = object.getString("description");
                    String link = object.getString("urlToImage");
                    String date = object.getString("publishedAt");
                    Pojo pojo = new Pojo(name,author,title,desc,link,date);
                    list.add(pojo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MyAdapter adapter = new MyAdapter(MainActivity.this,list);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("key","failed to fetch");
            }
        });

    }
}