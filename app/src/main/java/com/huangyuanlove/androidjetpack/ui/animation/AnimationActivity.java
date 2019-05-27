package com.huangyuanlove.androidjetpack.ui.animation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.huangyuanlove.androidjetpack.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {


    private AppCompatButton sharedElementButton;
    private AppCompatImageView sharedElementImageView;
    private AppCompatTextView sharedElementTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         *1、打开FEATURE_CONTENT_TRANSITIONS开关(可选)，这个开关默认是打开的
         */
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        /**
         *2、设置除ShareElement外其它View的退出方式(左边滑出)
         */
        getWindow().setExitTransition(new Slide(Gravity.LEFT));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        findViewById(R.id.animation_drawable_graphics).setOnClickListener(this);
        findViewById(R.id.reveal_or_hide_view).setOnClickListener(this);
        findViewById(R.id.shared_element).setOnClickListener(this);

        sharedElementButton = findViewById(R.id.shared_element_button);
        sharedElementImageView = findViewById(R.id.shared_element_image);
        sharedElementTextView = findViewById(R.id.shared_element_text);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animation_drawable_graphics:
                startActivity(new Intent(AnimationActivity.this, AnimationDrawableGraphicsActivity.class));
                break;
            case R.id.reveal_or_hide_view:
                startActivity(new Intent(AnimationActivity.this, RevealOrHideViewActivity.class));
                break;
            case R.id.shared_element:

                // Check if we're running on Android 5.0 or higher
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent intent = new Intent(AnimationActivity.this, SharedElementActivity.class);

                    Pair<View, String> pairButton = new Pair<View, String>(sharedElementButton, "button");
                    Pair<View, String> pairImage = new Pair<View, String>(sharedElementImageView, "image");
                    Pair<View, String> pairText = new Pair<View, String>(sharedElementTextView, "text");

                    ActivityOptionsCompat optionsCompat =
//                            ActivityOptionsCompat.makeSceneTransitionAnimation(AnimationActivity.this, v, "shared_button");
                            ActivityOptionsCompat.makeSceneTransitionAnimation(AnimationActivity.this, pairButton, pairImage, pairText);
                    startActivity(intent, optionsCompat.toBundle());


                } else {
                    // Swap without transition
                    startActivity(new Intent(AnimationActivity.this, SharedElementActivity.class));
                }

                break;
        }
    }
}
