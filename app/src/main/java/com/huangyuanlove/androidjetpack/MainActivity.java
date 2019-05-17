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

import com.huangyuanlove.androidjetpack.architecture.lifecycles.LifecycleObserverActivity;
import com.huangyuanlove.androidjetpack.architecture.livedata.LiveDataActivity;
import com.huangyuanlove.androidjetpack.architecture.navigation.NavigationActivity;
import com.huangyuanlove.androidjetpack.foundation.AppCompatViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, NavigationActivity.class));

        findViewById(R.id.notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNotification();
                    }
                }, 3000);


            }
        });


    }

    private void showNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "take_photo";
            String channelName = "拍照选择图片";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationManager
                    notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = notificationManager.getNotificationChannel(channelId);
            if (channel == null) {
                channel = new NotificationChannel(channelId, channelName, importance);
            }
            notificationManager.createNotificationChannel(channel);
            if (channel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
                Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID, channel.getId());
                startActivity(intent);
                Toast.makeText(this, "请手动将通知打开", Toast.LENGTH_SHORT).show();
            } else {
                Notification nf = new Notification.Builder(this, channelId)
                        .setContentText("setContentText这是一个长的通知内容这是一个长的通知内容这是一个长的通知内容这是一个长的通知内容")
                        .setSettingsText("setSettingsText这是一个长的通知")
                        .setContentTitle("setContentTitle这是一个长的通知标题这是一个长的通知标题这是一个长的通知标题这是一个长的通知标题")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .build();
                notificationManager.notify(1, nf);
            }
        }
    }

}
