package com.dindinn.assignment

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.dindinn.assignment.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class MyApplication : Application(), HasAndroidInjector {

    companion object {
        @JvmStatic
        var appContext: Context? = null
    }

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}