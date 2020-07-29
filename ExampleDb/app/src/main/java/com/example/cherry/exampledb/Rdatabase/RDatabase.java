package com.example.cherry.exampledb.Rdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Rtable.class},version = 1,exportSchema = false)
public abstract class RDatabase extends RoomDatabase {
    public abstract Rdao rdao();
}
