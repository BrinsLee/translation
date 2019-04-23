package com.brins.translation

import android.app.Application

class TranslateApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        var instance: TranslateApplication? = null

    }

}