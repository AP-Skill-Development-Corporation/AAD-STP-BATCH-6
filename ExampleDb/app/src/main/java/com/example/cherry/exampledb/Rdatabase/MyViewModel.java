package com.example.cherry.exampledb.Rdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    MyRepository repository;
    LiveData<List<Rtable>> getAllData;
    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        getAllData = repository.readAllData();
    }
    /*This is for Insert Method*/
    public void insert(Rtable rtable){
        repository.insert(rtable);
    }
    /*This is for Delete Method*/
    public void delete(Rtable rtable){
        repository.delete(rtable);
    }
    /*This is for Update Method*/
    public void update(Rtable rtable){
        repository.update(rtable);
    }
    /*This is for reading the data*/
    public LiveData<List<Rtable>> readData(){
        return getAllData;
    }
}
