package com.huangyuanlove.androidjetpack.architecture.roomword;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "man")
public class Man {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")

    String name;

    @ColumnInfo(name = "age")
    int age;

}
