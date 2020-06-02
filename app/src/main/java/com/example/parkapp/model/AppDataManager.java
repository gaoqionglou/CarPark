package com.example.parkapp.model;

import androidx.room.Room;

import com.blankj.utilcode.util.Utils;

public class AppDataManager {
    private static AppDataManager instance;
    private AppDatabase appDatabase;

    private AppDataManager() {
        appDatabase = Room.databaseBuilder(Utils.getApp(),
                AppDatabase.class, "park_db").allowMainThreadQueries().build();
    }

    public static AppDataManager getInstance() {
        if (instance == null) {
            instance = new AppDataManager();
        }
        return instance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}