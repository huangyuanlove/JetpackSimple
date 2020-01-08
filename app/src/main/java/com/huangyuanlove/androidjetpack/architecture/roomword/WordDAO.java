package com.huangyuanlove.androidjetpack.architecture.roomword;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * Description:
 * Author: huangyuan
 * Create on: 2020-01-08
 * Email: huangyuan@chunyu.me
 */
@Dao
public interface WordDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

}
