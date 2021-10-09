package com.dindinn.assignment.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.dindinn.assignment.ui.main.MainActivity

@Suppress("unused")
@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}