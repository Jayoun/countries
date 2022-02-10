package com.airjany.mycountryapp01.model

import com.airjany.mycountryapp01.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {
    private val BASE_URL = "https://raw.githubusercontent.com"

    @Inject
    lateinit var api : CountriesAPI

    init {
        DaggerApiComponent.create().inject(this)
//        api = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//            .create(CountriesAPI::class.java)
    }

    fun getCountries(): Single<List<Country>>{
        return api.getCountries()
    }



}