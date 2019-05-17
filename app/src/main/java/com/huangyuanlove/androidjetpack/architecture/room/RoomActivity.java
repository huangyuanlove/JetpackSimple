package com.huangyuanlove.androidjetpack.architecture.room;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.huangyuanlove.androidjetpack.databinding.ActivityAppCompatViewBinding;

public class RoomActivity extends AppCompatActivity {


    ActivityAppCompatViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = DataBindingUtil.setContentView(this,R.layout.activity_room);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "jetpack").build();

    }
}
