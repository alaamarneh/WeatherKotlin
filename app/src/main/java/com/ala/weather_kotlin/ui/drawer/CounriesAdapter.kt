package com.ala.weather_kotlin.ui.drawer

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ala.weather_kotlin.R
import com.ala.weather_kotlin.model.Country
import com.ala.weather_kotlin.utils.ImageUtils
import com.bumptech.glide.Glide

class CountriesAdapter(private val countries: List<Country>, private val mListener: CountriesAdapterListener) :
    RecyclerView.Adapter<CountriesAdapter.CountryHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CountryHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_country, viewGroup, false)
        return CountryHolder(view)
    }

    override fun onBindViewHolder(countryHolder: CountryHolder, i: Int) {
        countryHolder.countryNameTv.setText(countries[i].name)
        countryHolder.regionTv.setText(countries[i].region)
        Glide.with(countryHolder.itemView.context)
            .load(ImageUtils.prepareImageUrl(countries[i].countryCode!!))
            .into(countryHolder.flagImg)
    }

    override fun getItemCount(): Int {
        return countries.size
    }


    inner class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryNameTv: TextView = itemView.findViewById(R.id.country_name_tv)
        var regionTv: TextView = itemView.findViewById(R.id.region_tv)
        var flagImg: ImageView = itemView.findViewById(R.id.flag_img)

        init {
            itemView.setOnClickListener { view -> mListener.onCountryClicked(countries[adapterPosition]) }

        }
    }

    interface CountriesAdapterListener {
        fun onCountryClicked(country: Country)
    }
}