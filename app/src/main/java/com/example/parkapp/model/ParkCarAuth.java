package com.example.parkapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ParkCarAuth {
    @PrimaryKey(autoGenerate = true)
    private int id;
    //车牌号码
    private String number;
    private Long authTime;

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

    public Long getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Long authTime) {
        this.authTime = authTime;
    }
}
