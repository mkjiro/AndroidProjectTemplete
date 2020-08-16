package com.example.temp.common.resource

import android.app.Activity
import androidx.annotation.StringRes

class GetString constructor(private val activity: Activity) {
    operator fun invoke(@StringRes resId: Int): String = activity.getString(resId)
}
