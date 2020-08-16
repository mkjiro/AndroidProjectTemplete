package com.example.temp.ui.home

import com.example.temp.base.BaseEvents

sealed class HomeEvents : BaseEvents {
    object ToNext : HomeEvents()
}
