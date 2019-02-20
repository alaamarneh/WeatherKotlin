package com.ala.weather_kotlin.ui.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ala.weather_kotlin.R
import com.ala.weather_kotlin.model.Country
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import com.ala.weather_kotlin.databinding.ActivityHomeBinding
import com.ala.weather_kotlin.ui.country.CountryFragment
import com.ala.weather_kotlin.ui.drawer.CountriesAdapter
import com.ala.weather_kotlin.ui.weather.WeatherFragment
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), CountriesAdapter.CountriesAdapterListener {

    lateinit var mBinding: ActivityHomeBinding

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCountryClicked(country: Country) {
        mBinding.drawerLayout.closeDrawers()

        val countryFragment = supportFragmentManager.findFragmentById(R.id.country_fragment) as CountryFragment
        countryFragment.update(country)

        val weatherFragment = supportFragmentManager.findFragmentById(R.id.weather_fragment) as WeatherFragment
        weatherFragment.update(country.latlng!![0], country.latlng!![1])
    }

    lateinit var mViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setSupportActionBar(toolbar)
        mViewModel = ViewModelProviders
            .of(this, factory)
            .get(HomeViewModel::class.java)
        mBinding.viewModel = mViewModel

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        mBinding.countriesRv.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        mViewModel.countriesLiveData
            .observe(this, Observer { response ->
                val adapter = CountriesAdapter(response!!, this)
                mBinding.countriesRv.adapter = adapter
            }
            )
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}
