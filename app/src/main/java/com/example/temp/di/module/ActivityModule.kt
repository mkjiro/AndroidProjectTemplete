package com.example.temp.di.module

import com.example.temp.di.scope.ActivityScope
import com.example.temp.ui.main.MainActivity
import com.example.temp.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class
        ]
    )
    fun contributesMainActivity(): MainActivity
}
