package com.huangyuanlove.androidjetpack.ui.animation;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.huangyuanlove.androidjetpack.R;

public class SharedElementActivity extends AppCompatActivity {

    private Button sharedButton;
    private TextView sharedTextView;
    private ImageView sharedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);
        sharedButton = findViewById(R.id.shared_element_button);
        sharedTextView = findViewById(R.id.shared_element_text);
        sharedImageView = findViewById(R.id.shared_element_image);

        /**
         * 1、设置相同的TransitionName
         */
        ViewCompat.setTransitionName(sharedButton,"button");
        ViewCompat.setTransitionName(sharedTextView,"text");
        ViewCompat.setTransitionName(sharedImageView,"image");
        /**
         * 2、设置WindowTransition,除指定的ShareElement外，其它所有View都会执行这个Transition动画
         */
        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Fade());
        /**
         * 3、设置ShareElementTransition,指定的ShareElement会执行这个Transiton动画
         */
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTarget(sharedButton);
        transitionSet.addTarget(sharedImageView);
        transitionSet.addTarget(sharedTextView);
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);


    }
}
