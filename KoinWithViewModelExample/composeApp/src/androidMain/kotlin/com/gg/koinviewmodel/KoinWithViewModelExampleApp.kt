package com.gg.koinviewmodel

import android.app.Application
import expect.KoinInitializer

class KoinWithViewModelExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(this).initKoin()
    }
}