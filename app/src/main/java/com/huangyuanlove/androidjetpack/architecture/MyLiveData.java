package com.huangyuanlove.androidjetpack.architecture;


import androidx.lifecycle.LiveData;

public class MyLiveData extends LiveData<Boolean> {


    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
