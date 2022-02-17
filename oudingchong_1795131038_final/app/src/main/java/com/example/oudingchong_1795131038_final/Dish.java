package com.example.oudingchong_1795131038_final;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dish {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dish_id")
    private long dishId;
    @ColumnInfo(name = "dish_name")
    private String dishName;
    @ColumnInfo(name = "dish_price")
    private int dishPrice;

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }
    public Dish(String dishName, int dishPrice){
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }
}
