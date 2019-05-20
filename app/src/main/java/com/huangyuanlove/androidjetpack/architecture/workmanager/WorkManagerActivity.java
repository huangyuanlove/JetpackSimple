package com.huangyuanlove.androidjetpack.architecture.workmanager;
//https://www.jianshu.com/p/e495ee6e84de
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;

import com.huangyuanlove.androidjetpack.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WorkManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss:SSS", Locale.getDefault());


        Constraints constraints=    new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)  // 网络状态
                .setRequiresBatteryNotLow(true)                 // 不在电量不足时执行
                .setRequiresCharging(true)                      // 在充电时执行
                .setRequiresStorageNotLow(true)                 // 不在存储容量不足时执行
//                .setRequiresDeviceIdle(true)                    // 在待机状态下执行，需要 API 23
                .build();

        Data data = new Data.Builder()
                .putString("time",simpleDateFormat.format(new Date()))
                .build();

        OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UploadWorker.class)
                .setConstraints(constraints)
                .setInputData(data)
                .build();
        WorkManager.getInstance(this).enqueue(uploadWorkRequest);
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uploadWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {

                 long timeStamp = workInfo.getOutputData().getLong("timestamp",0);
                Log.e("UploadWorker output",simpleDateFormat.format(timeStamp) +"--->"+workInfo.getState());
            }
        });
    }
}
