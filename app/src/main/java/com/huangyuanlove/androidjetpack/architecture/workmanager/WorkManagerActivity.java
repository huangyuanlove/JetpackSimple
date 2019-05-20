package com.huangyuanlove.androidjetpack.architecture.workmanager;
//https://www.jianshu.com/p/e495ee6e84de
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;

import android.os.Bundle;

import com.huangyuanlove.androidjetpack.R;

public class WorkManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);
        OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UploadWorker.class)
                .build();
        Operation operation =  WorkManager.getInstance(this).enqueue(uploadWorkRequest);
        operation.getState();
    }
}
