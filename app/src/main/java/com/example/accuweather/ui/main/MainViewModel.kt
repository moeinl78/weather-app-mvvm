package com.example.accuweather.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accuweather.data.model.FiveDayModel
import com.example.accuweather.data.model.LocationDB
import com.example.accuweather.data.model.LocationModelItem
import com.example.accuweather.repository.MainRepository
import com.example.accuweather.utils.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    private val _locationKey = MutableLiveData<Resources<List<LocationModelItem>>>()
    private val _fiveDayForecast = MutableLiveData<Resources<FiveDayModel>>()
    private val _locations = MutableLiveData<List<LocationDB>>()

    val locationKey: LiveData<Resources<List<LocationModelItem>>>
        get() = _locationKey

    val fiveDayModel: LiveData<Resources<FiveDayModel>>
        get() = _fiveDayForecast

    val locations: LiveData<List<LocationDB>>
        get() = _locations

    fun requestLocationKey(cityName: String) {
        getLocationKey(cityName)
    }

    fun requestFiveDayModel(key: String) {
        getFiveDayForecast(key)
    }

    fun insertLocation(locationDB: LocationDB) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.insertLocation(locationDB)
        }
    }

    fun removeLocation(locationDB: LocationDB) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.removeLocation(locationDB)
        }
    }

    fun getLocations() {
        viewModelScope.launch(Dispatchers.IO) {
            _locations.postValue(mainRepository.getLocations().value)
        }
    }

    private fun getLocationKey(cityName: String) {
        _locationKey.postValue(Resources.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = mainRepository.getCityLocation(cityName)
                if (response.isSuccessful) {
                    _locationKey.postValue(Resources.Success(response.body()!!))
                }
                else {
                    _locationKey.postValue(Resources.Error(response.message()))
                }
            }
            catch (error: Exception) {
                Log.e("MainViewModel", error.message!!)
            }
        }
    }

    private fun getFiveDayForecast(key: String) {
        _fiveDayForecast.postValue(Resources.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = mainRepository.getFiveDayForecast(key)
                if(response.isSuccessful) {
                    _fiveDayForecast.postValue(Resources.Success(response.body()!!))
                }
                else {
                    _fiveDayForecast.postValue(Resources.Error(response.message()))
                }
            }
            catch (error: Exception) {
                Log.e("MainViewModel", error.message!!)
            }
        }
    }
}