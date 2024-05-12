package com.listener.pokemonapp

import android.app.Application
import com.listener.pokemonapp.di.app.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        DI.appComponent = DaggerAppComponent
            .builder()
            .appContext(this)
            .build()
    }
}