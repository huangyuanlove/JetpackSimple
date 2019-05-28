package com.huangyuanlove.androidjetpack.behavior.mediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.huangyuanlove.androidjetpack.R;

public class MediaPlayerActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        videoView = findViewById(R.id.videoView);
//        videoView.setVideoURI(Uri.parse("http://www.w3school.com.cn/i/movie.mp4"));
        videoView.setVideoPath("http://www.w3school.com.cn/i/movie.mp4");
        //创建MediaController对象
        MediaController mediaController = new MediaController(this);

        //VideoView与MediaController建立关联
        videoView.setMediaController(mediaController);


        //让VideoView获取焦点
        videoView.requestFocus();


        findViewById(R.id.full_screen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
                layoutParams.width = 1440;
                layoutParams.height = 2560;
                videoView.setLayoutParams(layoutParams);
            }
        });


    }
}
