package com.example.temp.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.temp.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
