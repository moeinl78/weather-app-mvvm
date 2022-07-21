package com.example.accuweather.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.accuweather.data.model.LocationDB

@Dao
interface LocationDAO {
    @Insert
    suspend fun insertLocation(locationDB: LocationDB)

    @Delete
    suspend fun removeLocation(locationDB: LocationDB)

    @Query("SELECT * FROM location_table")
    fun getLocations(): LiveData<List<LocationDB>>
}