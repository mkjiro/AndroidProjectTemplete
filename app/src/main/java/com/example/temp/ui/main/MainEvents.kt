package com.example.temp.ui.main

import com.example.temp.base.BaseEvents

sealed class MainEvents : BaseEvents {
    object Success : MainEvents()
    object Error : MainEvents()
}
