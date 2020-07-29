package com.example.cherry.exampledb.Rdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {
    RDatabase rDatabase;
    LiveData<List<Rtable>> list;

    public MyRepository(Application application){
        rDatabase = RDatabase.getrDatabase(application);
        list = rDatabase.rdao().getall();
    }
    public  void insert(Rtable rtable){
        new InsertTask().execute(rtable);
    }
    public void delete(Rtable rtable){
        new DeleteTask().execute(rtable);
    }
    public void update(Rtable rtable){
        new UpdateTask().execute(rtable);
    }
    class InsertTask extends AsyncTask<Rtable,Void,Void>{
        @Override
        protected Void doInBackground(Rtable... rtables) {
            for (int i=0;i<rtables.length;i++){
                rDatabase.rdao().insert(rtables[i]);
            }
            return null;
        }
    }
    public LiveData<List<Rtable>> readAllDate(){
        return list;
    }
    class DeleteTask extends AsyncTask<Rtable,Void,Void>{
        @Override
        protected Void doInBackground(Rtable... rtables) {
            rDatabase.rdao().delete(rtables[0]);
            return null;
        }
    }
    class UpdateTask extends AsyncTask<Rtable,Void,Void>{
        @Override
        protected Void doInBackground(Rtable... rtables) {
            rDatabase.rdao().update(rtables[0]);
            return null;
        }
    }


}
