package com.ala.weather_kotlin.ui.weather

import androidx.lifecycle.MutableLiveData
import com.ala.weather_kotlin.di.repo.DataRepo
import com.ala.weather_kotlin.model.Weather
import com.ala.weather_kotlin.ui.base.BaseViewModel
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val dataRepo: DataRepo) : BaseViewModel() {

    val weatherLiveData = MutableLiveData<List<Weather>>()

    fun loadWeatherData(lat: Double, lng: Double) {
        addDisposable(dataRepo.getWeather(lat, lng)
            .subscribeWithLoading(onSuccess = { weatherLiveData.value = it }))
    }
}