package com.example.parkapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 */
@Dao
public interface ParkCarAuthDao {
    @Query("SELECT * FROM parkcarauth")
     List<ParkCarAuth> getAllCarAuth();

    @Query("SELECT EXISTS (SELECT * FROM parkcarauth WHERE number  = :number)")
    boolean isAuth(String number);

    @Update
    void updateParkCarAuth(ParkCarAuth parkCar);

    @Insert
    void insertParkCarAuth(ParkCarAuth parkCar);

    @Delete
    void deleteParkCarAuth(ParkCarAuth parkCar);
}
