package com.ala.weather_kotlin.utils

import com.ala.weather_kotlin.R
import com.ala.weather_kotlin.model.Weather

object ImageUtils{

    fun prepareImageUrl(countryCode: String): String {
        return "http://www.geognos.com/api/en/countries/flag/$countryCode.png"
    }

    fun getImageResourceByWeather(weather: Weather): Int {
        return R.drawable.ic_sun_solid
    }

}