package com.example.parkapp.model;

import android.icu.text.Replaceable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 */
@Dao
public interface ParkCarDao {
    @Query("select * from parkCar where status = 1")
    List<ParkCar> getAllCarInPark();
    @Query("select * from parkCar where status = 1")
    LiveData<List<ParkCar>> getAllCarInParkObrs();

    @Query("SELECT EXISTS (SELECT * FROM parkCar WHERE number  = :path)")
    boolean isAuth(String path);

    @Query("SELECT EXISTS (SELECT * FROM parkCar WHERE number  = :number and status = 1)")
    boolean isParkIn(String number);

    @Query("select * from parkcar where number = :number")
    ParkCar find(String number);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateParkCar(ParkCar parkCar);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertParkCar(ParkCar parkCar);

    @Delete
    void deleteParkCar(ParkCar parkCar);
}
