package com.officegym.liftme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LiftMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
