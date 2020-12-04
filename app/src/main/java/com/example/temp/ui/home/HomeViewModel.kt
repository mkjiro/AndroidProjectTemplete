package com.example.temp.ui.home

import com.example.temp.base.BaseViewModel
import com.example.temp.ui.livedata.EventLiveData
import javax.inject.Inject

class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeEvents>() {
    override val liveEvent =
        EventLiveData<HomeEvents>()
}
