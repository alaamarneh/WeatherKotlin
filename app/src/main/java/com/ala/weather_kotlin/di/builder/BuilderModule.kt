package com.ala.weather_kotlin.di.builder

import com.ala.weather_kotlin.ui.country.CountryFragment
import com.ala.weather_kotlin.ui.home.HomeActivity
import com.ala.weather_kotlin.ui.weather.WeatherFragment
import com.ala.weather_kotlin.ui.weather.details.WeatherDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule{
    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun bindCountryFragment(): CountryFragment

    @ContributesAndroidInjector
    abstract fun bindWeatherFragment(): WeatherFragment

    @ContributesAndroidInjector
    abstract fun bindWeatherDetailsFragment(): WeatherDetailsFragment

}