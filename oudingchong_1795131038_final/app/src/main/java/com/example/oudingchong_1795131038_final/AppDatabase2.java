package com.example.oudingchong_1795131038_final;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities ={User.class},version = 1,exportSchema = false)

public abstract class AppDatabase2 extends RoomDatabase {
    public abstract UserDao userDao();
}