package com.huangyuanlove.androidjetpack.architecture.lifecycles;


import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver implements LifecycleObserver {


    private String tag;
    public MyLifecycleObserver(String tag){
        this.tag = tag;
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.e(tag,"ON_CREATE");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        Log.e(tag,"ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        Log.e(tag,"ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        Log.e(tag,"ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        Log.e(tag,"ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        Log.e(tag,"ON_DESTROY");
    }


}
