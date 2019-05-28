package com.huangyuanlove.androidjetpack.architecture.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class UserViewModel extends AndroidViewModel {
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    private String name;
    private int age;
    private String sex;

    private MutableLiveData<Integer> valueChanged = new MutableLiveData<>();

    public MutableLiveData<Integer> getValueChanged() {
        return valueChanged;
    }

    public void setValueChanged(MutableLiveData<Integer> valueChanged) {
        this.valueChanged = valueChanged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
