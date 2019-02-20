package com.ala.weather_kotlin.di.repo

import com.ala.weather_kotlin.BuildConfig
import com.ala.weather_kotlin.utils.isToday
import com.ala.weather_kotlin.utils.isTomorrow
import com.ala.weather_kotlin.utils.secondsToMillis
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.model.Weather
import com.ala.weather_kotlin.net.CountryApiHelper
import com.ala.weather_kotlin.net.WeatherApiHelper
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepoImpl @Inject
constructor(private val countryApiHelper: CountryApiHelper, private val weatherApiHelper: WeatherApiHelper) : DataRepo {
    override fun getAllCountries(): Single<List<Country>> {
        return countryApiHelper.getAllCountries()
    }

    override fun getWeather(lat: Double, lng: Double): Single<List<Weather>> {
        return weatherApiHelper.getWeather(lat, lng, BuildConfig.OPEN_WATHER_API_KEY)
            .map { weatherResponse ->
                //filter the list of weathers, return the weather of today and tomorrow.
                val weathers = ArrayList<Weather>()
                var todayWeather: Weather? = null
                var tomorrowWeather: Weather? = null
                weatherResponse.listOfWeathers?.forEach {
                    if (todayWeather == null && it.date.secondsToMillis().isToday()) {
                        todayWeather = it

                    } else if (it.date.secondsToMillis().isTomorrow()) { // if tomorrow
                        tomorrowWeather = it
                        return@forEach
                    }
                }

                weathers.add(todayWeather!!)
                weathers.add(tomorrowWeather!!)
                return@map weathers
            }
    }


}

