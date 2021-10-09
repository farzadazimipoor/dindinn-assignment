package com.dindinn.assignment

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import com.dindinn.assignment.di.AppInjector
import javax.inject.Inject

open class MyApp : Application(), HasAndroidInjector {

    companion object {
        @JvmStatic
        var appContext: Context? = null
    }

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}