package com.example.cherry.exampledb.Rdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Rdao {

    @Query("select * from Student")
    List<Rtable> getall();

    @Insert()
    void insert(Rtable rtable);
}
