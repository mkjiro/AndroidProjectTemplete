package com.example.temp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.temp.di.ByFactory
import com.example.temp.di.ViewModelKey
import com.example.temp.di.get
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel


    @Module
    companion object {

        @JvmStatic
        @Provides
        @ByFactory
        fun providesHomeViewModel(
            fragment: HomeFragment,
            viewModelFactory: ViewModelProvider.Factory
        ): HomeViewModel = viewModelFactory.get(fragment)
    }
}
