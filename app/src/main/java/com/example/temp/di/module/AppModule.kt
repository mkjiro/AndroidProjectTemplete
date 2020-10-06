package com.example.temp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.temp.App
import com.example.temp.BuildConfig
import com.example.temp.data.DataModule
import com.example.temp.domain.DomainModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule

@Module(
    includes = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        DomainModule::class,
        DataModule::class,
        ActivityModule::class
    ]
)
abstract class AppModule {

    @Binds
    abstract fun provideApplication(app: App): Application

    @Binds
    abstract fun provideApplicationContext(application: Application): Context

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesSharedPreferences(
            context: Context
        ): SharedPreferences = context.getSharedPreferences(
            BuildConfig.APPLICATION_ID,
            AppCompatActivity.MODE_PRIVATE
        )
    }
}


