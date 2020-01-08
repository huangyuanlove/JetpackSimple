package com.huangyuanlove.androidjetpack.architecture.roomword;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Description:
 * Author: huangyuan
 * Create on: 2020-01-08
 * Email: huangyuan@chunyu.me
 */
@Entity(tableName = "word_table")
public class Word  {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    public Word(@NonNull String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
