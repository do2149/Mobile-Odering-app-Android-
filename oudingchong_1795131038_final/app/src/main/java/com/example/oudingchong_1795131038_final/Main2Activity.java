package com.example.oudingchong_1795131038_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    OrderDishDao orderDishDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        final Button button10 = findViewById(R.id.button10);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"order_info").allowMainThreadQueries().build();
        orderDishDao = db.orderDishDao();
        TextView textView = findViewById(R.id.textView8);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("order_name");
        final String arrivetime = intent.getStringExtra("arrive_time");
        showOrderWithDishes(name);
        TextView textView28 = findViewById(R.id.textView28);
        textView28.setText(textView28.getText()+arrivetime);
        CustomerOrder customerOrder = orderDishDao.loadOneCustomerOrder(name);
        if (customerOrder.getOrderStatus().equals("preparing")){
            button10.setEnabled(false);
        }
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.length()>0){
                    //String currentOrderName = spinner.getSelectedItem().toString();
                    CustomerOrder currentOrder = orderDishDao.loadOneCustomerOrder(name);
                    currentOrder.setOrderStatus("Finished");
                    orderDishDao.updateOneOrder(currentOrder);
                    showOrderWithDishes(currentOrder.getOrderName());
                    button10.setEnabled(true);
                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                CustomerOrder currentOrder = orderDishDao.loadOneCustomerOrder(name);
                intent.putExtra("order_name",currentOrder.getOrderName());
                startActivity(intent);
            }
        });
    }

    public void showOrderWithDishes(String orderName){
        TextView textView = findViewById(R.id.textView8);
        TextView textView15 = findViewById(R.id.textView15);
        OrderWithDishes orderWithDishes = orderDishDao.getOrderWithDishes(orderName);
        String text = orderWithDishes.getCustomerOrder().getOrderName()+":"+"\n";
        //text = text + orderWithDishes.getCustomerOrder().getOrderStatus()+"\n";
        int totalPrice = 0;
        for (int i=0; i<orderWithDishes.getDishes().size(); i++){
            text = text +(i+1);
            text = text +" "+orderWithDishes.getDishes().get(i).getDishName() ;
            text = text +" "+orderWithDishes.getDishes().get(i).getDishPrice()+"\n";
            totalPrice = totalPrice + orderWithDishes.getDishes().get(i).getDishPrice();
        }
        text = text+"Total Price:" +totalPrice;
        textView.setText(text);
        textView15.setText("当前状态："+orderWithDishes.getCustomerOrder().getOrderStatus());
        //textView6.setText("总计："+Integer.toString(totalPrice));
    }

}
