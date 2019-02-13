package com.ala.weather_kotlin.ui.weather


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ala.weather_kotlin.databinding.FragmentWeatherBinding
import com.ala.weather_kotlin.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class WeatherFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var binding : FragmentWeatherBinding
    lateinit var viewModel : WeatherViewModel

    var weatherAdapter : WeatherPagerAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false)
        viewModel = ViewModelProviders.of(this,factory)
            .get(WeatherViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.tabs.setupWithViewPager(binding.viewpager)

        viewModel.weatherLiveData
            .observe(this, Observer { weathers ->
                if (weathers == null) return@Observer
                if (weatherAdapter == null){
                    weatherAdapter = WeatherPagerAdapter(childFragmentManager, weathers)
                    binding.viewpager.adapter = weatherAdapter
                }else{
                    weatherAdapter!!.updateWeathers(weathers)
                }
            })

        return binding.root
    }

    fun update(lat : Double, lng : Double){
        viewModel.loadWeatherData(lat,lng)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


}
