package com.example.cherry.exampledb.Rdatabase;

import androidx.room.Database;

@Database(entities = {Rtable.class},version = 1,exportSchema = false)
public abstract class RDatabase {
    public abstract Rdao rdao();
}
