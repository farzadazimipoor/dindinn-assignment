package com.dindinn.assignment.di

import com.dindinn.assignment.presentation.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}