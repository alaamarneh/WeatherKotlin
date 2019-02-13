package com.ala.weather_kotlin.ui.weather.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ala.weather_kotlin.R
import com.ala.weather_kotlin.model.Weather
import com.ala.weather_kotlin.utils.DateUtils
import com.ala.weather_kotlin.utils.ImageUtils
import javax.inject.Inject

class WeatherDetailsViewModel @Inject constructor(private val app: Application) : AndroidViewModel(app) {
    val date = MutableLiveData<String>()
    val pressure = MutableLiveData<String>()
    val humidity = MutableLiveData<String>()
    val temp = MutableLiveData<String>()
    val imageResource = MutableLiveData<Int>()

    fun setWeather(weather: Weather?){
        if (weather == null) return
        date.value = DateUtils.getDayName(weather.date)
        pressure.value = "${weather.weatherMain!!.pressure}"
        humidity.value = "${weather.weatherMain!!.humidity}"
        temp.value = app.getString(R.string.temp, weather.weatherMain!!.tempMin.toString(),weather.weatherMain!!.tempMax.toString())
        imageResource.value = ImageUtils.getImageResourceByWeather(weather)
    }
}
