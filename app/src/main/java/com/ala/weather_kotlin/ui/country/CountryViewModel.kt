package com.ala.weather_kotlin.ui.country

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ala.weather_kotlin.model.Country
import javax.inject.Inject

class CountryViewModel  @Inject constructor(): ViewModel() {

    val country = MutableLiveData<Country>()

    fun setCountry(country: Country) {
        this.country.setValue(country)
    }
}
