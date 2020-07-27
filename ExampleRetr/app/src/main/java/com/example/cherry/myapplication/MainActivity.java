package com.example.cherry.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Policy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Retrofit retrofit;
    MyInterface myInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
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
                    String title = object.getString("title");
                    String link = object.getString("urlToImage");
                    Pojo pojo = new Pojo(title,link);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("key","failed to fetch");
            }
        });

    }
}