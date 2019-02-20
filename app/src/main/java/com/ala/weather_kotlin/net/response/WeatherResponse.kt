package com.ala.weather_kotlin.net.response

import com.ala.weather_kotlin.model.Weather
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("cod")
    val code: Int = 0,

    @SerializedName("list")
    val listOfWeathers: List<Weather>? = null
)