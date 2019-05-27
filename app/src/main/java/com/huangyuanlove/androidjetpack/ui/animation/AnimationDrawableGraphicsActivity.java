package com.huangyuanlove.androidjetpack.ui.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangyuanlove.androidjetpack.R;

public class AnimationDrawableGraphicsActivity extends AppCompatActivity {

    private ImageView animationDrawbleImageView;
    private AnimationDrawable rocketAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable_graphics);
        animationDrawbleImageView = findViewById(R.id.animation_drawable);
        animationDrawbleImageView.setBackgroundResource(R.drawable.animation_drawable);

        rocketAnimation = (AnimationDrawable) animationDrawbleImageView.getBackground();

        animationDrawbleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rocketAnimation.start();
            }
        });


        ImageView vectorDrawableImageView = findViewById(R.id.vector_drawable);
        vectorDrawableImageView.setBackgroundResource(R.drawable.animvectordrawable);
        final AnimatedVectorDrawable vectorDrawable = (AnimatedVectorDrawable) vectorDrawableImageView.getBackground();
        vectorDrawableImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vectorDrawable.start();
            }
        });



    }
}
