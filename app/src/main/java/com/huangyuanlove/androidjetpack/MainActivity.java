package com.huangyuanlove.androidjetpack;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.huangyuanlove.androidjetpack.architecture.lifecycles.LifecycleObserverActivity;
import com.huangyuanlove.androidjetpack.architecture.livedata.LiveDataActivity;
import com.huangyuanlove.androidjetpack.architecture.navigation.NavigationActivity;
import com.huangyuanlove.androidjetpack.architecture.paging.PagingActivity;
import com.huangyuanlove.androidjetpack.architecture.room.RoomActivity;
import com.huangyuanlove.androidjetpack.architecture.viewmodel.ViewModelActivity;
import com.huangyuanlove.androidjetpack.architecture.workmanager.WorkManagerActivity;
import com.huangyuanlove.androidjetpack.databinding.ActivityMainBinding;

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
        binding.workManager.setOnClickListener(this);
        binding.paging.setOnClickListener(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
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
                        Toast.makeText(MainActivity. this, "请手动将通知打开", Toast.LENGTH_SHORT).show();
                    } else {
                        Notification nf = new Notification.Builder(MainActivity.this, channelId)
                                .setContentText("setContentText")
                                .setSettingsText("setSettingsText")
                                .setContentTitle("setContentTitle")
                                .setSmallIcon(R.drawable.ic_launcher_background)
                                .build();
                        notificationManager.notify(1, nf);
                    }
                }else{

                }



                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("提示");
                builder.setMessage("请选择你要进行的操作");
                //	第一个按钮
                builder.setPositiveButton("设置手机隐私密码", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        //	提示信息
                        Toast toast = Toast.makeText(getApplicationContext(), "你选择了覆盖", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                //	中间的按钮
                builder.setNeutralButton("确认删除", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        //	提示信息
                        Toast toast = Toast.makeText(getApplicationContext(), "你选择了跳过", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                //	第三个按钮
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        //	提示信息
                        Toast toast = Toast.makeText(getApplicationContext(), "你选择了取消", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                //	Diglog的显示
                builder.create().show();


            }
        },3000);




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
            case R.id.workManager:
                startActivity(new Intent(MainActivity.this, WorkManagerActivity.class));
                break;
            case R.id.paging:
                startActivity(new Intent(MainActivity.this, PagingActivity.class));
                break;
            default:
                break;
        }
    }
}
