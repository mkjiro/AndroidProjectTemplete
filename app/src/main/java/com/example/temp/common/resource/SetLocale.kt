package com.example.temp.common.resource

import android.app.Activity
import android.content.res.Configuration
import java.util.Locale

class SetLocale(private val activity: Activity) {
    operator fun invoke(local: Locale) {
        Locale.setDefault(local)
        val configuration = Configuration().apply {
            setLocale(local)
        }
        activity.createConfigurationContext(configuration)
    }
}