package com.example.oudingchong_1795131038_final;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities ={CustomerOrder.class,Dish.class,OrderDishCrossRef.class},version = 1,exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public abstract OrderDishDao orderDishDao();
}

