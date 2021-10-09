package com.dindinn.assignment.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.dindinn.assignment.ui.main.MainFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}