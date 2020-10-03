package com.example.temp.common.util

import android.os.Handler
import android.os.Looper
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

interface Timeout{
    fun start()
}

class TimeoutByRxjava{
    private val timeoutDisposable = CompositeDisposable()
    private var scheduler = Schedulers.newThread()

    fun start(delay: Long = 1000,onTimeout:()->Unit):TimeoutByRxjava{
        timeoutDisposable.clear()
        Timber.w("startTimeout")
        Completable.timer(delay, TimeUnit.MILLISECONDS)
            .observeOn(scheduler)
            .subscribe({
                onTimeout()
            }, {
                Timber.e(it)
            })
            .let(timeoutDisposable::add)
        return this
    }

    fun stop() {
        Timber.w("stopTimeout")
        timeoutDisposable.clear()
    }

    fun setCallbackThread(scheduler: Scheduler):TimeoutByRxjava{
        this.scheduler = scheduler
        return this
    }
}

class TimeoutByCoroutine{

    private var job = SupervisorJob()
    private var scope = CoroutineScope(Dispatchers.Default + job)

    fun start(delay: Long = 1000,onTimeout:()->Unit):TimeoutByCoroutine{
        scope.launch{
            delay(delay)
            onTimeout()
        }
        return this
    }

    fun stop() {
        scope.cancel()
    }

    fun setCallbackThread(dispatcher: CoroutineDispatcher):TimeoutByCoroutine{
        scope = CoroutineScope(dispatcher + job)
        return this
    }

}

class TimeoutByHandler{

    private var handler:Handler? = null

    fun start(delay: Long = 1000,onTimeout:()->Unit):TimeoutByHandler{
        handler = Handler(
            Looper.getMainLooper()
        )
        handler?.postDelayed({
            {
               onTimeout()
            }
        },delay)
        return this
    }

    fun stop() {
        
    }

    fun setCallbackThread(dispatcher: CoroutineDispatcher):TimeoutByHandler{
        return this
    }
}