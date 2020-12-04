package com.example.temp.ui.next

import com.example.temp.base.BaseViewModel
import com.example.temp.ui.livedata.EventLiveData
import javax.inject.Inject

class NextViewModel @Inject constructor(
) : BaseViewModel<NextEvents>() {
    override val liveEvent =
        EventLiveData<NextEvents>()
}
