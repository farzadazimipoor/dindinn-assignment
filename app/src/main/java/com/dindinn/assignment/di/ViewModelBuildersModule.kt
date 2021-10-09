package com.dindinn.assignment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dindinn.assignment.common.helpers.MyViewModelFactory
import com.dindinn.assignment.presentation.main.MainViewModel
import com.dindinn.assignment.presentation.orders.ui.main.PageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelBuildersModule {

    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PageViewModel::class)
    abstract fun bindPagerViewModel(pageViewModel: PageViewModel): ViewModel
}