package com.example.oudingchong_1795131038_final;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EvaluationDao {
    @Insert
    void insertOneEvaluation(Evaluation evaluation);

    @Query("SELECT * FROM Evaluation")
    List<Evaluation> loadAllEvaluation();
}
