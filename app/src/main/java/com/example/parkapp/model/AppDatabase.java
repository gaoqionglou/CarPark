package com.example.parkapp.model;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.blankj.utilcode.util.Utils;

/**
 */
@Database(entities = {ParkCar.class,ParkCarAuth.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ParkCarDao parkCarDao();
    public abstract ParkCarAuthDao parkCarAuthDao();


    private static AppDatabase javaDatabase;

    public static AppDatabase instance(){
        if(javaDatabase==null){
            synchronized (AppDatabase.class){
                if(javaDatabase==null){
                    javaDatabase= Room.databaseBuilder(Utils.getApp(),AppDatabase.class,"doc").
                            addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    System.out.println("onCreate==========="+db.getVersion()+"==="+db.getPath());
                                }

                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    System.out.println("onOpen==========="+db.getVersion()+"==="+db.getPath());
                                }
                            })
                            .allowMainThreadQueries()//允许在主线程查询数据
                            .fallbackToDestructiveMigration()//迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
                            .build();
                }
            }
        }
        return javaDatabase;
    }
}
