package com.example.temp.ui.main

import com.example.temp.base.BaseViewModel
import com.example.temp.ui.livedata.EventLiveData
import com.example.temp.ui.main.MainEvents
import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
) : BaseViewModel<MainEvents>(){
    override val liveEvent =
        EventLiveData<MainEvents>()

    override fun onStartWithDisposables(disposables: CompositeDisposable) {
        super.onStartWithDisposables(disposables)
    }

    override fun onStop() {
        super.onStop()
    }

}
