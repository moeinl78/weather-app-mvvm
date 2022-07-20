package com.example.accuweather.utils

sealed class Resources<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): Resources<T>(data, null)
    class Error<T>(message: String): Resources<T>(null, message)
    class Loading<T>: Resources<T>()
}