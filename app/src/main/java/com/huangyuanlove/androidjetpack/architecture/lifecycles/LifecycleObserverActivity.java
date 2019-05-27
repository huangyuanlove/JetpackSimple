package com.huangyuanlove.androidjetpack.architecture.lifecycles;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.huangyuanlove.androidjetpack.R;

public class LifecycleObserverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_observer);
        getLifecycle().addObserver(new MyLifecycleObserver());
    }
}
