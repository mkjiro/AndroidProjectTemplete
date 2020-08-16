package com.example.temp.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.temp.common.resource.GetString
import com.example.temp.common.resource.GetStringArray
import com.example.temp.di.ByFactory
import com.example.temp.di.ViewModelKey
import com.example.temp.di.get
import com.example.temp.di.scope.FragmentScope
import com.example.temp.ui.home.HomeFragment
import com.example.temp.ui.home.HomeModule
import com.example.temp.ui.next.NextFragment
import com.example.temp.ui.next.NextModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {
    @Binds
    abstract fun bindsAppCompatActivity(activity: MainActivity): AppCompatActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributesHomeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [NextModule::class])
    abstract fun contributesNextFragment(): NextFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(viewModel: MainViewModel): ViewModel

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ByFactory
        fun providesMainViewModel(
            activity: AppCompatActivity,
            viewModelFactory: ViewModelProvider.Factory
        ): MainViewModel = viewModelFactory.get(activity)

        @JvmStatic
        @Provides
        fun providesGetString(
            activity: AppCompatActivity
        ): GetString {
            return GetString(activity)
        }

        @JvmStatic
        @Provides
        fun providesGetStringArray(
            activity: AppCompatActivity
        ): GetStringArray {
            return GetStringArray(activity)
        }
    }
}

