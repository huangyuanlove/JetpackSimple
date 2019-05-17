package com.huangyuanlove.androidjetpack.foundation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.huangyuanlove.androidjetpack.R;
import com.huangyuanlove.androidjetpack.databinding.ActivityAppCompatViewBinding;

public class AppCompatViewActivity extends AppCompatActivity {

    ActivityAppCompatViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_app_compat_view);
    }
}
