package com.example.temp.ui.main

import android.os.*
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.temp.BuildConfig
import com.example.temp.R
//import com.google.firebase.perf.FirebasePerformance
import com.example.temp.base.BaseActivity
import com.example.temp.databinding.ActivityMainBinding
import com.example.temp.ui.livedata.EventLiveDataObserver
import com.example.temp.di.ByFactory
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    @field:ByFactory
    lateinit var viewModel: MainViewModel

    lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.w("onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // start tracing performance
        init()
//        FirebasePerformance.getInstance().newTrace("main_trace").start()
    }

    private fun init() {
        Locale.setDefault(Locale.JAPANESE)
        lifecycle.run {
            addObserver(viewModel.disposableObserver)
        }
        initNavigationEvent()
        configureNavController()

        binding.textVersion.text = BuildConfig.VERSION_NAME
    }

    private fun initNavigationEvent() {
        viewModel.liveEvent.observe(
            this,
            EventLiveDataObserver(
                this::onMainNavigationEventReceive
            )
        )
    }

    private fun onMainNavigationEventReceive(event: MainEvents) {
        when (event) {
            MainEvents.Success -> {}
            else -> {}
        }
    }

    private fun configureNavController() {
        navController = findNavController(R.id.nav_controller)
        navController.addOnDestinationChangedListener { _, _, _ ->
        }
    }

    override fun onDestroy() {
        Timber.w("onDestroy()")
//        FirebasePerformance.getInstance().newTrace("main_trace").stop()
        super.onDestroy()
    }
}