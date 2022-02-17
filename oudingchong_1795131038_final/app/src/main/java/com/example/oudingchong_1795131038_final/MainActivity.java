package com.example.oudingchong_1795131038_final;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    OrderDishDao orderDishDao;
    //EvaluationDao evaluationDao;
    TextView textView1,textView2,textView3,textView4,textView5,textView9,textView10,textView11,textView12,textView13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        Button button = (Button)findViewById(R.id.button);
        Button button1 = (Button)findViewById(R.id.button2);
        Button button2 = (Button)findViewById(R.id.button3);
        Button button3 = (Button)findViewById(R.id.button4);
        Button button4 = (Button)findViewById(R.id.button5);
        Button button5 = (Button)findViewById(R.id.button6);
        Button button6 = findViewById(R.id.button7);
        Button button12 = findViewById(R.id.button12);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        TextView textView20 = findViewById(R.id.textView20);
        textView20.setText("欢迎您："+ username);
        final Dish[] dishes = new Dish[5];
        Random random1 = new Random();
        dishes[0] = new Dish("锅包肉",35 ); dishes[0].setDishId(random1.nextLong());
        dishes[1] =new Dish("地三鲜",18);  dishes[1].setDishId(random1.nextLong());
        dishes[2] = new Dish("锅贴" ,30);dishes[2].setDishId(random1.nextLong());
        dishes[3] = new Dish("猪肉炖粉条", 35);dishes[3].setDishId(random1.nextLong());
        dishes[4] = new Dish("菠萝肉", 35 );dishes[4].setDishId(random1.nextLong());
        //dishes[5] = new Dish("京酱肉丝", 40);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"order_info").allowMainThreadQueries().build();
        orderDishDao = db.orderDishDao();

        ArrayAdapter<CustomerOrder> adapter;
        orderDishDao.insertMultiDishes(dishes);

        textView1.setText(dishes[0].getDishName());textView2.setText(dishes[1].getDishName());textView3.setText(dishes[2].getDishName());textView4.setText(dishes[3].getDishName());textView5.setText(dishes[4].getDishName());
        textView9.setText(Integer.toString(dishes[0].getDishPrice()));textView10.setText(Integer.toString(dishes[1].getDishPrice()));textView11.setText(Integer.toString(dishes[2].getDishPrice()));textView12.setText(Integer.toString(dishes[3].getDishPrice()));textView13.setText(Integer.toString(dishes[4].getDishPrice()));
        //adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_item,orderNames  );
        final TextView textView7 = findViewById(R.id.textView7);
        //final long orderId = 45455;
        final List<Dish> order = new ArrayList<>();
        final List<Integer> total = new  ArrayList<>();
        final int index = 0;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView);
                order.add(dishes[0]);
                //textView7.setText(order.get(0));
                total.add(35);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView2);
                order.add(dishes[1]);
                total.add(18);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView3);
                order.add(dishes[2]);
                total.add(30);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView4);
                order.add(dishes[3]);
                total.add(35);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView5);
                order.add(dishes[4]);
                total.add(35);
            }
        });
        Random random = new Random();
        final long num = random.nextLong();
        final CustomerOrder customerOrder = new CustomerOrder("order_"+Long.toString(num),"preparing");
        customerOrder.setOrderId(num);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView7);
                TextView textView1 = findViewById(R.id.textView6);

                String order1 = new String();
                int sum = 0;

                OrderDishCrossRef[] orderDishCrossRefs = new OrderDishCrossRef[5];
                int index1 = 0;

                long orderId1 = orderDishDao.insertOneOrder(customerOrder);
                Iterator<Dish> iterator = order.iterator();
                Iterator<Integer> iterator1 = total.iterator();
                while(iterator.hasNext()){
                    orderDishCrossRefs[index1] = new OrderDishCrossRef(num,iterator.next().getDishId());
                    System.out.println("kaishi:"+orderDishCrossRefs[index1].getOrderId());
                    index1++;
                }
                //textView.setText(Long.toString(orderDishCrossRefs[0].getOrderId()));
                orderDishDao.insertMultiDishesForOneOrder(orderDishCrossRefs);
                showOrderWithDishes(customerOrder.getOrderName());

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                LocalDateTime localDateTime = LocalDateTime.now();
                LocalDateTime arriveTime = localDateTime.plusMinutes(30);
                String time = localDateTime.toString();
                time = time.substring(0,time.length()-4);
                String atime = arriveTime.toString();
                atime = atime.substring(0,atime.length()-4);
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("order_name",customerOrder.getOrderName());
                intent.putExtra("order_time",time);
                intent.putExtra("arrive_time",atime);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
    }
    public void showOrderWithDishes(String orderName){
        TextView textView = findViewById(R.id.textView7);
        TextView textView6 = findViewById(R.id.textView6);
        OrderWithDishes orderWithDishes = orderDishDao.getOrderWithDishes(orderName);
        String text = orderWithDishes.getCustomerOrder().getOrderName()+":";
        text = text + orderWithDishes.getCustomerOrder().getOrderStatus()+"\n";
        int totalPrice = 0;
        for (int i=0; i<orderWithDishes.getDishes().size(); i++){
            text = text +(i+1);
            text = text +" "+orderWithDishes.getDishes().get(i).getDishName() ;
            text = text +" "+orderWithDishes.getDishes().get(i).getDishPrice()+"\n";
            totalPrice = totalPrice + orderWithDishes.getDishes().get(i).getDishPrice();
        }
        //text = text+"Total Price:" +totalPrice;
        textView.setText(text);
        textView6.setText("总计："+Integer.toString(totalPrice));
    }
}
