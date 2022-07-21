package com.example.accuweather.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.accuweather.data.model.LocationDB

@Database(entities = [LocationDB::class], version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract fun getLocationDAO(): LocationDAO

    companion object {
        private var dataBase: DataBase? = null

        fun createDatabase(context: Context): DataBase {
            synchronized(this) {
                if(dataBase == null) {
                    dataBase = Room
                        .databaseBuilder(
                            context,
                            DataBase::class.java,
                            "database"
                        )
                        .build()
                }
            }
            return dataBase!!
        }
    }
}