package com.ala.weather_kotlin.ui.country

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ala.weather_kotlin.R
import com.ala.weather_kotlin.databinding.FragmentCountryDetailsBinding
import com.ala.weather_kotlin.helpers.ImageLoader
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.utils.ImageUtils
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CountryFragment : Fragment() {

    private lateinit var mBinding: FragmentCountryDetailsBinding

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var mViewModel: CountryViewModel

    @Inject
    lateinit var mImageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("tag", "fragment created")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_country_details, container, false)
        mViewModel = ViewModelProviders
            .of(this, factory)
            .get(CountryViewModel::class.java!!)
        mBinding.viewModel = mViewModel
        mBinding.lifecycleOwner = this

        mViewModel.country
            .observe(this, Observer{ country ->
                if (country == null) return@Observer
                mImageLoader!!.loadIntoImage(mBinding.flagImg, ImageUtils.prepareImageUrl(country.countryCode!!))
            })
        return mBinding.getRoot()
    }


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    fun update(country: Country) {
        mViewModel.setCountry(country)
    }




}
