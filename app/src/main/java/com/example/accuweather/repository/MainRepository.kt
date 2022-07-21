package com.example.accuweather.repository

import com.example.accuweather.data.local.LocationDAO
import com.example.accuweather.data.model.LocationDB
import com.example.accuweather.data.remote.ServiceAPI

class MainRepository(private val serviceAPI: ServiceAPI, private val locationDAO: LocationDAO) {

    suspend fun getCityLocation(cityName: String) =
        serviceAPI.getCityLocation(cityName)

    suspend fun getFiveDayForecast(locationKey: String) =
        serviceAPI.getFiveDayForecast(locationKey)

    suspend fun insertLocation(locationDB: LocationDB) =
        locationDAO.insertLocation(locationDB)

    suspend fun removeLocation(locationDB: LocationDB) =
        locationDAO.removeLocation(locationDB)

    suspend fun getLocations() =
        locationDAO.getLocations()
}