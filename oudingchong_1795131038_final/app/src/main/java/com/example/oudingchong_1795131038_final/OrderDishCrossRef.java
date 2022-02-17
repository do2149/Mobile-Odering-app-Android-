package com.example.oudingchong_1795131038_final;



import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"order_id","dish_id"})

public class OrderDishCrossRef {
    @ColumnInfo(name = "order_id")
    private long orderId;
    @ColumnInfo(name = "dish_id",index = true)
    private  long dishId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderIdl(long orderId) {
        this.orderId = orderId;
    }

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public OrderDishCrossRef(long orderId, long dishId){
        this.orderId = orderId;
        this.dishId = dishId;
    }
}
