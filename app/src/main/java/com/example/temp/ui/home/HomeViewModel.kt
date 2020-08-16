package com.example.temp.ui.home

import com.example.temp.common.resource.GetString
import com.example.temp.base.BaseViewModel
import com.example.temp.ui.home.HomeEvents
import com.example.temp.ui.livedata.EventLiveData
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeEvents>() {
    override val liveEvent =
        EventLiveData<HomeEvents>()

}
