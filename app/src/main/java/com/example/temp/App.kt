package com.example.temp

import com.example.temp.BuildConfig.DEBUG
import com.example.temp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        if (DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        RxJavaPlugins.setErrorHandler {
            Timber.e(it)
        }
    }
}
