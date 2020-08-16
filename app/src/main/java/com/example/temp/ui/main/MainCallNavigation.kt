package com.example.temp.ui.main

import android.os.Bundle
import com.example.temp.base.BaseEvents

sealed class MainCallNavigation : BaseEvents {
    object FinishActivity : MainCallNavigation()
    object ToHome : MainCallNavigation()
    object CheckPermissions : MainCallNavigation()
    object CallRequest : MainCallNavigation()
    data class AcceptCall(val bundle: Bundle) : MainCallNavigation()

}
