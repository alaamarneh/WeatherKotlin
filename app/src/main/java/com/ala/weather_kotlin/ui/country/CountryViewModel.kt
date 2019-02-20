package com.ala.weather_kotlin.ui.country

import androidx.lifecycle.MutableLiveData
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.ui.base.BaseViewModel
import javax.inject.Inject

class CountryViewModel  @Inject constructor(): BaseViewModel() {

    val country = MutableLiveData<Country>()

    fun setCountry(country: Country) {
        this.country.setValue(country)
    }
}
