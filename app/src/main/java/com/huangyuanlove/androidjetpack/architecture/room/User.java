package com.huangyuanlove.androidjetpack.architecture.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "user",indices = {@Index(value = {"id","name"},unique = true)})
//@Entity(primaryKeys = {"id", "name"})
public class User {


    public User() {
    }

    public User(int id, int age, String name, Address address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }


    public long id;

    @ColumnInfo(name = "age")
    public int age;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "sex")
    public String sex;


    @Embedded
    public Address address;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
