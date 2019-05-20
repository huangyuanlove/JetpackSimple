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
    void inserUsers(ArrayList<User> users);

    @Update
    void updateUser(User user);
    @Update
    void updateUsers(ArrayList<User> users);

    @Delete
    void deleteUser(User user);
    @Delete
    void deleteUsers(ArrayList<User> users);

    @Query("select * from user")
    List<User> getAllUsers();
    @Query("select * from user where id=:id")
    User getUserByID(int id);


}
