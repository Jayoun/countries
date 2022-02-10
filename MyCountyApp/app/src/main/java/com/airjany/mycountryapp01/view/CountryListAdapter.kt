package com.airjany.mycountryapp01.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airjany.mycountryapp01.R
import com.airjany.mycountryapp01.databinding.ItemCountryBinding
import com.airjany.mycountryapp01.model.Country
import com.airjany.mycountryapp01.util.loadImage

class CountryListAdapter(var countries:ArrayList<Country>):
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries : List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country,parent,false )

        return CountryViewHolder(ItemCountryBinding.bind(view));
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    class CountryViewHolder(binding : ItemCountryBinding) : RecyclerView.ViewHolder(binding.root){

        private val countryName = binding.name
        private val capital = binding.capital
        private val flag = binding.imageView

        fun bind(country: Country){
            countryName.text = country.countryName
            capital.text = country.capital
            flag.loadImage(country.flag)
        }
    }
}