package com.ala.weather_kotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ala.weather_kotlin.di.ViewModelFactory
import com.ala.weather_kotlin.di.ViewModelKey
import com.ala.weather_kotlin.ui.country.CountryViewModel
import com.ala.weather_kotlin.ui.home.HomeViewModel
import com.ala.weather_kotlin.ui.weather.WeatherViewModel
import com.ala.weather_kotlin.ui.weather.details.WeatherDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule{

    @Binds
    internal abstract fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CountryViewModel::class)
    internal abstract fun bindCountryViewModel(country: CountryViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(home: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    internal abstract fun bindWeatherViewModel(weatherViewModel: WeatherViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherDetailsViewModel::class)
    internal abstract fun bindWeatherDetailsViewModel(weatherDetailsViewModel: WeatherDetailsViewModel) : ViewModel

}