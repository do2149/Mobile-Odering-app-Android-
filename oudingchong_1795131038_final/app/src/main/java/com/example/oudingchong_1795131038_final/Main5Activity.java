package com.example.oudingchong_1795131038_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    EvaluationDao evaluationDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        AppDatabase1 db1 = Room.databaseBuilder(getApplicationContext(),AppDatabase1.class,"evaluation_info").allowMainThreadQueries().build();
        evaluationDao = db1.evaluationDao();
        TextView textView18 = findViewById(R.id.textView18);
        List<Evaluation> evaluationList = evaluationDao.loadAllEvaluation();
        Iterator<Evaluation> iterator = evaluationList.iterator();
        String text = new String();

        while(iterator.hasNext()){
            Evaluation current = iterator.next();
            text = text + current.getUserName()+"     " +"星级：" +current.getStarnum() +"\n";
            text = text + "评价：" +current.getComment() +"\n"+ "\n";
        }

        textView18.setText(text);


    }
}
