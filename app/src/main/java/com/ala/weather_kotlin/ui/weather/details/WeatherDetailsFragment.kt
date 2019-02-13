package com.ala.weather_kotlin.ui.weather.details

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.ala.weather_kotlin.R
import com.ala.weather_kotlin.databinding.WeatherDetailsFragmentBinding
import com.ala.weather_kotlin.model.Weather
import dagger.android.support.AndroidSupportInjection

class WeatherDetailsFragment : Fragment() {

    companion object {
        const val ARG_WEATHER = "weather"
        fun newInstance(weather: Weather): WeatherDetailsFragment {
            val fragment = WeatherDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_WEATHER, weather)
            fragment.arguments = bundle
            return fragment

        }
    }

    var weather: Weather? = null

    lateinit var binding: WeatherDetailsFragmentBinding

    private lateinit var viewModel: WeatherDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null && arguments!!.containsKey(ARG_WEATHER))
            weather = arguments!!.getParcelable(ARG_WEATHER)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.weather_details_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherDetailsViewModel::class.java)
        binding.viewModel = viewModel
        update(weather)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


    private fun update(weather: Weather?){
        viewModel.setWeather(weather)
    }

}
