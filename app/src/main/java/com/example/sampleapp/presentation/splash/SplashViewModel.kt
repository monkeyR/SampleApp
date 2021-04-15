package com.example.sampleapp.presentation.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.example.sampleapp.presentation.common.SingleEventLiveData

class SplashViewModel : ViewModel() {

    companion object {
        const val SPLASH_DURATION = 5000L
    }

    val closeSplashTrigger =
        SingleEventLiveData<Unit>()

    fun onCreated() {
        Handler(Looper.getMainLooper()).postDelayed(
            { closeSplashTrigger.postValue(Unit) },
            SPLASH_DURATION
        )
    }
}