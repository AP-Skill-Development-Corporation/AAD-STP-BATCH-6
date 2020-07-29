package com.example.cherry.exampledb.Rdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Rtable.class},version = 1,exportSchema = false)
public abstract class RDatabase extends RoomDatabase {
    public abstract Rdao rdao();
    public static RDatabase rDatabase;

    public static synchronized RDatabase getrDatabase(Context context){
        if (rDatabase==null){
            rDatabase = Room.databaseBuilder(context,RDatabase.class,"MYROOM")
                    .allowMainThreadQueries().build();
        }
        return rDatabase;
    }
}
