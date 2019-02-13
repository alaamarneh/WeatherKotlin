package com.ala.weather_kotlin.ui.weather

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.ala.weather_kotlin.model.Weather
import com.ala.weather_kotlin.ui.weather.details.WeatherDetailsFragment

class WeatherPagerAdapter(fm: FragmentManager, var weathers : List<Weather>) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return weathers.size
    }

    override fun getItem(position: Int): Fragment {
        return WeatherDetailsFragment.newInstance(weathers[position])
    }

    fun updateWeathers(weathers: List<Weather>){
        this.weathers = weathers
        this.notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Today"
            else -> "Tomorrow"
        }
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

}