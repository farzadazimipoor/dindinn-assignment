package com.dindinn.assignment.di

import com.dindinn.assignment.presentation.ingredients.ui.main.IngredientsListFragment
import com.dindinn.assignment.presentation.orders.ui.main.CollectionOrdersFragment
import com.dindinn.assignment.presentation.orders.ui.main.IncomingOrdersFragment
import com.dindinn.assignment.presentation.orders.ui.main.PreparingOrdersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeIncomingOrdersFragment(): IncomingOrdersFragment

    @ContributesAndroidInjector
    abstract fun contributePreparingOrdersFragment(): PreparingOrdersFragment

    @ContributesAndroidInjector
    abstract fun contributeCollectionOrdersFragment(): CollectionOrdersFragment

    @ContributesAndroidInjector
    abstract fun contributeIngredientsFragment(): IngredientsListFragment
}