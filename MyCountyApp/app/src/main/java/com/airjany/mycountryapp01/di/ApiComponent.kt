package com.airjany.mycountryapp01.di

import com.airjany.mycountryapp01.model.CountriesService
import com.airjany.mycountryapp01.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)
    fun inject(viewModel : ListViewModel)
}