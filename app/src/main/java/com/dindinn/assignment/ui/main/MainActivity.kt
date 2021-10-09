package com.dindinn.assignment.ui.main

import android.os.Bundle
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import com.dindinn.assignment.R
import com.dindinn.assignment.ui.common.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}