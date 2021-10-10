package com.dindinn.assignment.di

import com.dindinn.assignment.presentation.ingredients.IngredientsActivity
import com.dindinn.assignment.presentation.main.MainActivity
import com.dindinn.assignment.presentation.orders.OrdersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeOrdersActivity(): OrdersActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeIngredientsActivity(): IngredientsActivity
}