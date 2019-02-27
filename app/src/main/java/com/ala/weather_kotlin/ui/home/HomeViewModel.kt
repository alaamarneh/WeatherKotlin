package com.ala.weather_kotlin.ui.home

import androidx.lifecycle.MutableLiveData
import com.ala.weather_kotlin.di.repo.DataRepo
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val dataRepo: DataRepo) : BaseViewModel() {

    val countriesLiveData: MutableLiveData<List<Country>> = MutableLiveData()

    init {
        loadCountries()
    }

    private fun loadCountries() {
        addDisposable(dataRepo.getAllCountries()
            .subscribeWithLoading(onSuccess = {countriesLiveData.value = it}))

    }
}