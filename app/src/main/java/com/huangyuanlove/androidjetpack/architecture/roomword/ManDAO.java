package com.huangyuanlove.androidjetpack.architecture.roomword;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface ManDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Man man);

    @Query("DELETE FROM man")
    void deleteAll();

    @Query("SELECT * from man ORDER BY man.age ASC")
    LiveData<List<Man>> getAlphabetizedWords();
}
