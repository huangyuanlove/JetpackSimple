package com.huangyuanlove.androidjetpack;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.huangyuanlove.androidjetpack.architecture.lifecycles.LifecycleObserverActivity;
import com.huangyuanlove.androidjetpack.architecture.livedata.LiveDataActivity;
import com.huangyuanlove.androidjetpack.architecture.navigation.NavigationActivity;
import com.huangyuanlove.androidjetpack.architecture.room.RoomActivity;
import com.huangyuanlove.androidjetpack.architecture.viewmodel.ViewModelActivity;
import com.huangyuanlove.androidjetpack.databinding.ActivityMainBinding;
import com.huangyuanlove.androidjetpack.foundation.AppCompatViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.lifecycles.setOnClickListener(this);
        binding.liveData.setOnClickListener(this);
        binding.navigation.setOnClickListener(this);
        binding.room.setOnClickListener(this);
        binding.viewmodel.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lifecycles:
                startActivity(new Intent(MainActivity.this,LifecycleObserverActivity.class));
                break;
            case R.id.live_data:
                startActivity(new Intent(MainActivity.this,LiveDataActivity.class));
                break;
            case R.id.navigation:
                startActivity(new Intent(MainActivity.this,NavigationActivity.class));
                break;
            case R.id.room:
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
                break;
            case R.id.viewmodel:
                startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
                break;
            default:
                break;
        }
    }
}
