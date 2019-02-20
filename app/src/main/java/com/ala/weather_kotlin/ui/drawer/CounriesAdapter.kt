package com.ala.weather_kotlin.ui.drawer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ala.weather_kotlin.BR
import com.ala.weather_kotlin.databinding.ItemCountryBinding
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.ui.base.BaseViewHolder

class CountriesAdapter(private val countries: List<Country>, private val mListener: CountriesAdapterListener) :
    RecyclerView.Adapter<CountriesAdapter.CountryHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CountryHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val itemBinding = ItemCountryBinding.inflate(inflater, viewGroup, false)
        return CountryHolder(itemBinding)
    }

    override fun onBindViewHolder(countryHolder: CountryHolder, i: Int) {
        countryHolder.bind(countries[i])
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class CountryHolder(private val itemCountryBinding: ItemCountryBinding) : BaseViewHolder<Country>(itemCountryBinding) {
        override fun bind(item: Country) {
            itemCountryBinding.country = item
        }
        init {
            itemView.setOnClickListener { mListener.onCountryClicked(countries[adapterPosition]) }
        }
    }

    interface CountriesAdapterListener {
        fun onCountryClicked(country: Country)
    }
}