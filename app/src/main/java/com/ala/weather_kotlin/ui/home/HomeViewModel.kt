package com.ala.weather_kotlin.ui.home

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.di.repo.DataRepo
import com.ala.weather_kotlin.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val dataRepo: DataRepo) : BaseViewModel() {
    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val countriesLiveData: MutableLiveData<List<Country>> = MutableLiveData()

    init {
        loadCountries()
    }

    private fun loadCountries() {
        isLoading.set(true)
        disposable.add(dataRepo.getAllCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { countries ->
                countriesLiveData.value = countries
                isLoading.set(false)
            })
    }
}