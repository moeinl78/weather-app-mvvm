package com.example.accuweather.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.accuweather.data.model.LocationDB

@Database(entities = [LocationDB::class], version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract fun getLocationDAO(): LocationDAO
}