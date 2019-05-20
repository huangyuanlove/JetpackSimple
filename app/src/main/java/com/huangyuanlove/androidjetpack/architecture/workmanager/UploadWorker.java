package com.huangyuanlove.androidjetpack.architecture.workmanager;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UploadWorker extends Worker {

    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e("UploadWorker input",getInputData().getString("time"));

        Data outputData = new Data.Builder()
                .putLong("timestamp",System.currentTimeMillis())
                .build();


        return Result.success(outputData);
    }
}
