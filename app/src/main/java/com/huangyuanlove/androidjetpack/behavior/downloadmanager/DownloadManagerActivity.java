package com.huangyuanlove.androidjetpack.behavior.downloadmanager;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.huangyuanlove.androidjetpack.R;

//https://www.jianshu.com/p/a1389db471c2
public class DownloadManagerActivity extends AppCompatActivity {
    private CompleteReceiver completeReceiver;
    private long downLoadid = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager);

        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String downloadUrl = "http://resume.huangyuanlove.com/%E9%98%BF%E9%87%8CAndroid%E5%BC%80%E5%8F%91%E8%A7%84%E8%8C%83%E8%AF%81%E4%B9%A6.jpg";
                DownloadManager mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                Uri resource = Uri.parse(downloadUrl);

                DownloadManager.Request request = new DownloadManager.Request(resource);
                request.setTitle("正在下载title");
                request.setDescription("下载描述");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);



                request.setDestinationInExternalFilesDir(DownloadManagerActivity.this,Environment.DIRECTORY_DOWNLOADS, "debug.apk");
                // 设置文件类型
                MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
                String mimeString = mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap
                        .getFileExtensionFromUrl(downloadUrl));
                request.setMimeType(mimeString);

                downLoadid =   mDownloadManager.enqueue(request);


            }
        });
        completeReceiver = new CompleteReceiver();
        //register download success broadcast
        registerReceiver(completeReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(completeReceiver);
    }

    class CompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            long completeDownloadId = intent.getLongExtra(
                    DownloadManager.EXTRA_DOWNLOAD_ID, 0);
            Toast.makeText(context,"下载完成",Toast.LENGTH_SHORT).show();

        }
    }

}
