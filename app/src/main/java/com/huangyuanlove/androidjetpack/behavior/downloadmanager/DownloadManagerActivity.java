package com.huangyuanlove.androidjetpack.behavior.downloadmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.view.View;

import com.huangyuanlove.androidjetpack.R;
//https://www.jianshu.com/p/a1389db471c2
public class DownloadManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager);

        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String downloadUrl = "https://facai.chunyu.me/apk/ChunyuDoctorClient_5.1.0__release_test_e61339626d703685.apk";
                DownloadManager mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                Uri resource = Uri.parse(downloadUrl);

                DownloadManager.Request request = new DownloadManager.Request(resource);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "debug.apk");
                //start 一些非必要的设置
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setVisibleInDownloadsUi(true);
                request.setTitle("正在下载。。title");
//end 一些非必要的设置

                mDownloadManager.enqueue(request);


            }
        });

    }
}
