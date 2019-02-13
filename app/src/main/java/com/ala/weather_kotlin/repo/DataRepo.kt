package com.ala.weather_kotlin.repo

import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.model.Weather
import io.reactivex.Single

interface DataRepo{
    fun getAllCountries(): Single<List<Country>>
    fun getWeather(lat: Double, lng: Double): Single<List<Weather>>
}