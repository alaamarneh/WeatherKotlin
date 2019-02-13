package com.ala.weather_kotlin.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ala.weather_kotlin.model.Weather
import com.ala.weather_kotlin.repo.DataRepo
import com.ala.weather_kotlin.ui.base.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val dataRepo: DataRepo) : BaseViewModel() {
    val weatherLiveData = MutableLiveData<List<Weather>>()
    val isLoading = MutableLiveData<Boolean>()
    fun loadWeatherData(lat: Double, lng: Double) {
        isLoading.value = true
        disposable.add(dataRepo.getWeather(lat, lng)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                weatherLiveData.value = data
                isLoading.value = false
            }
        )
    }


}