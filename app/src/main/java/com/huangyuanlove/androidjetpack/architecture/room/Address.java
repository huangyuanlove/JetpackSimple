package com.huangyuanlove.androidjetpack.architecture.room;

import androidx.room.ColumnInfo;

public class Address {
    public Address(String city, int postCode) {
        this.city = city;
        this.postCode = postCode;
    }

    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;

    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", postCode=" + postCode +
                '}';
    }
}
