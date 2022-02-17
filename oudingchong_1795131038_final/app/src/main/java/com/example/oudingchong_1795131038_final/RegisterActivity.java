package com.example.oudingchong_1795131038_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oudingchong_1795131038_final.ui.login.LoginActivity;

import java.net.IDN;
import java.util.Random;

public class RegisterActivity extends AppCompatActivity {
    UserDao  userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText editText2 = findViewById(R.id.editText2);
        final EditText editText3 = findViewById(R.id.editText3);
        final EditText editText4 = findViewById(R.id.editText4);
        final EditText editText5 = findViewById(R.id.editText5);
        Button button14 = findViewById(R.id.button14);
        Button button15 = findViewById(R.id.button15);
        final RadioGroup radioGroup = findViewById(R.id.radiogroup);
        AppDatabase2 db2 = Room.databaseBuilder(getApplicationContext(),AppDatabase2.class,"user_info").allowMainThreadQueries().build();
        userDao = db2.userDao();
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText2.getText().toString();
                String gender = new String();
                int rdoId = radioGroup.getCheckedRadioButtonId();
                switch (rdoId){
                    case R.id.radioButton: gender = "男"; break;
                    case R.id.radioButton2: gender = "女"; break;
                    default: break;
                }
                String phone = editText3.getText().toString();
                String address = editText4.getText().toString();
                String password = editText5.getText().toString();
                User user = new User(username,password,gender,address,phone);
                Random random = new Random();
                Long l1 = (long)random.nextInt(100000);
                user.setUserId(l1);
                Long l = user.getUserId();
                String myId = l.toString();
                userDao.InsertOneUser(user);
                //Toast.makeText(RegisterActivity.this,"myId",Toast.LENGTH_LONG);
                TextView textView27 = findViewById(R.id.textView27);
                textView27.setText(Long.toString(l1));
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
