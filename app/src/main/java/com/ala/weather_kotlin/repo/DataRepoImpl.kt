package com.ala.weather_kotlin.repo

import android.text.format.DateUtils
import com.ala.weather_kotlin.BuildConfig
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.model.Weather
import com.ala.weather_kotlin.net.CountryApiHelper
import com.ala.weather_kotlin.net.WeatherApiHelper
import io.reactivex.Single
import java.util.ArrayList
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
                for (weather in weatherResponse.listOfWeathers!!) {

                    if (todayWeather == null && DateUtils.isToday(weather.date * 1000)) {
                        todayWeather = weather

                    } else if (DateUtils.isToday(weather.date * 1000 - DateUtils.DAY_IN_MILLIS)) { // if tomorrow
                        tomorrowWeather = weather
                        break
                    }

                }

                weathers.add(todayWeather!!)
                weathers.add(tomorrowWeather!!)
                weathers
            }
    }
}

