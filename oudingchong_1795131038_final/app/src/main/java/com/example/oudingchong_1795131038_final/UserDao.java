package com.example.oudingchong_1795131038_final;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert
    void InsertOneUser(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void UpdateOneUser(User user);

    @Query("SELECT * FROM User WHERE user_id = (:userId)")
    User getOneUser(long userId);

}
