package com.huangyuanlove.androidjetpack.architecture.room;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import com.huangyuanlove.androidjetpack.R;
import com.huangyuanlove.androidjetpack.databinding.ActivityAppCompatViewBinding;
import com.huangyuanlove.androidjetpack.databinding.ActivityRoomBinding;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayAdapter<String> adapter;
    ArrayList<String> userInfos;
    ActivityRoomBinding binding;
    AppDatabase db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_room);
       db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "jetpack.db").build();
        binding.add.setOnClickListener(this);
        binding.update.setOnClickListener(this);
        binding.delete.setOnClickListener(this);
        binding.query.setOnClickListener(this);
        binding.queryAll.setOnClickListener(this);
        userInfos = new ArrayList<>();

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,userInfos);
        binding.usersListView.setAdapter(adapter);
    }

    void showAllUsers(){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.e("room",Thread.currentThread().getName());
                       final List<User> users  = db.userDao().getAllUsers();


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                userInfos.clear();
                                adapter.clear();
                                for(User user : users){
                                    userInfos.add(user.toString());
                                }
                                adapter.notifyDataSetChanged();
                            }
                        });



                    }
                }
        ).start();

    }


    @Override
    public void onClick(View v) {
      final  User user = new User();
        switch (v.getId()){
            case R.id.add:

                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                user.age = Integer.valueOf(binding.age.getText().toString());
                                user.name = binding.name.getText().toString();
                                user.id = System.currentTimeMillis();
                                Address address = new Address(binding.city.getText().toString(),binding.postCode.getText().toString());
                                user.address = address;
                                db.userDao().insertUser(user);
                                showAllUsers();
                            }
                        }
                ).start();

                break;
            case R.id.delete:
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                user.name = binding.name.getText().toString();
                                db.userDao().deleteUser(user);
                                showAllUsers();
                            }
                        }
                ).start();

                break;
            case R.id.update:
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                user.age = Integer.valueOf(binding.age.getText().toString());
                                user.name = binding.name.getText().toString();
                                user.id = System.currentTimeMillis();
                                Address address = new Address(binding.city.getText().toString(),binding.postCode.getText().toString());
                                user.address = address;
                                db.userDao().updateUser(user);
                                showAllUsers();
                            }
                        }
                ).start();




                break;
            case R.id.query:
                db.userDao().getUserByID(123);
                break;
            case R.id.query_all:
                showAllUsers();
                break;
                default:break;
        }
    }
}
