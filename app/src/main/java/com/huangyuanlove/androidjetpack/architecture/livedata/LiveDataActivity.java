package com.huangyuanlove.androidjetpack.architecture.livedata;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.huangyuanlove.androidjetpack.R;

public class LiveDataActivity extends AppCompatActivity {

    private MutableLiveData<String> liveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        liveData = new MutableLiveData<>();
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("LiveData_one",s);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        liveData.setValue("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        liveData.setValue("onResume");
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("LiveData_two",s);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveData.setValue("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        liveData.setValue("onDestroy");
    }
}
