package com.example.parkapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"id","number"})
public class ParkCar {
    private int id;
    //车牌号码
    @NonNull
    private String number;
    //车辆状态 0 空闲 1 进入
    private int status;
    //是否是授权车辆
    private boolean isAuth;
    //进入时间
    private Long enterTime;
    //驶出时间
    private Long outTime;
    //停车时间
    private Long parkTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    public Long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Long enterTime) {
        this.enterTime = enterTime;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    public Long getParkTime() {
        return parkTime;
    }

    public void setParkTime(Long parkTime) {
        this.parkTime = parkTime;
    }
}
