package com.example.accuweather.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accuweather.data.model.FiveDayModel
import com.example.accuweather.data.model.LocationModel
import com.example.accuweather.repository.MainRepository
import com.example.accuweather.utils.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    private val _locationKey = MutableLiveData<Resources<LocationModel>>()
    private val _fiveDayForecast = MutableLiveData<Resources<FiveDayModel>>()

    val locationKey: LiveData<Resources<LocationModel>>
        get() = _locationKey

    val fiveDayModel: LiveData<Resources<FiveDayModel>>
        get() = _fiveDayForecast

    fun requestLocationKey(cityName: String) {
        getLocationKey(cityName)
    }

    fun requestFiveDayModel(key: String) {
        getFiveDayForecast(key)
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