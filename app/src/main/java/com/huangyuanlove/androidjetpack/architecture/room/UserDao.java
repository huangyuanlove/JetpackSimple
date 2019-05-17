package com.huangyuanlove.androidjetpack.architecture.room;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
interface UserDao {

    @Insert
    void insertUser(User user);
    @Insert
    int inserUsers(ArrayList<User> users);

    @Update
    int updateUser(User user);
    @Update
    int updateUsers(ArrayList<User> users);

    @Delete
    int deleteUser(User user);
    @Delete
    int deleteUsers(ArrayList<User> users);

    @Query("select * from user")
    List<User> getAllUsers();
    @Query("select * from user where id=:id")
    User user(int id);


}
