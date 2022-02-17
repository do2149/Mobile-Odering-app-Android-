package com.example.oudingchong_1795131038_final;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities ={Evaluation.class},version = 1,exportSchema = false)

public abstract class AppDatabase1 extends RoomDatabase {
    public abstract EvaluationDao evaluationDao();
}
