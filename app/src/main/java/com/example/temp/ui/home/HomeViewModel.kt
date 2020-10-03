package com.example.temp.ui.home

import com.example.temp.base.BaseViewModel
import com.example.temp.common.util.TimeoutByCoroutine
import com.example.temp.domain.rxjava.Sample1Impl
import com.example.temp.ui.livedata.EventLiveData
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeEvents>() {
    override val liveEvent =
        EventLiveData<HomeEvents>()

    var timeout:TimeoutByCoroutine? = null

    override fun onStartWithDisposables(disposables: CompositeDisposable) {
        super.onStartWithDisposables(disposables)

//        Main.run()
        Timber.d("Start")
        timeout = TimeoutByCoroutine()
            .setCallbackThread(Dispatchers.Main)
            .start(10000){
                Timber.d("Complete")
            }
        Timber.d("End")
    }

}

object Main {
    fun run() {
        val sample1 = Sample1Impl()
        sample1()
            .map {
                it + it
            }
            .flatMap {
                Timber.d("%s",it)
                Single.just(it)
            }
            .subscribe(
            {text ->
                Timber.d("text: %s",text)
            },
            {
                Timber.e(it)
            }
        )
    }
}
