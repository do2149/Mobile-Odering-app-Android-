package com.example.oudingchong_1795131038_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    EvaluationDao evaluationDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final Spinner spinner = findViewById(R.id.spinner);
        final EditText editText = findViewById(R.id.editText);
        Button button11 = findViewById(R.id.button11);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("order_name");
        final TextView textView19 = findViewById(R.id.textView19);

        AppDatabase1 db1 = Room.databaseBuilder(getApplicationContext(),AppDatabase1.class,"evaluation_info").allowMainThreadQueries().build();
        evaluationDao = db1.evaluationDao();
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = spinner.getSelectedItemPosition();
                Evaluation evaluation = new Evaluation(name,getResources().getStringArray(R.array.starnum)[index],editText.getText().toString());
                //textView19.setText(evaluation.getUserName()+evaluation.getStarnum()+"/n"+evaluation.getComment());
                evaluationDao.insertOneEvaluation(evaluation);
                Intent intent = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
