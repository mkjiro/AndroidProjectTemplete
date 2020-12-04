package com.example.temp.base

import androidx.lifecycle.ViewModel
import com.example.temp.ui.livedata.EventLiveData
import com.example.temp.ui.livedata.LifecycleDisposable
import com.example.temp.ui.livedata.WithLifecycleDisposing
import com.example.temp.ui.livedata.lifecycleDisposable
import io.reactivex.Completable
import timber.log.Timber

abstract class BaseViewModel<Nav : BaseEvents>() :
    ViewModel(),
    WithLifecycleDisposing {
    abstract val liveEvent: EventLiveData<Nav>
    final override val disposableObserver: LifecycleDisposable by lifecycleDisposable()
    val resumeDisposables = disposableObserver.resumeDisposables
    val startDisposables = disposableObserver.startDisposables
    val createDisposables = disposableObserver.createDisposables

    protected fun Completable.subscribeWithStartDisposables(
        onComplete: (() -> Unit)? = null,
        onError: (() -> Throwable)? = null
    ) {
        subscribe({
            if (onComplete != null) {
                onComplete.invoke()
            } else {
                Timber.w("subscribeWithStartDisposables onComplete")
            }
        }, {
            if (onError != null) {
                onError.invoke()
            } else {
                Timber.e(it)
            }
        }).let(startDisposables::add)
    }
}
