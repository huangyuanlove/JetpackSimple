package com.huangyuanlove.androidjetpack.ui.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.huangyuanlove.androidjetpack.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        findViewById(R.id.animation_drawable_graphics).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. animation_drawable_graphics:
                startActivity(new Intent(AnimationActivity.this,AnimationDrawableGraphicsActivity.class));
                break;
        }
    }
}
