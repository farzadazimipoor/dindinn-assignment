package com.dindinn.assignment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.dindinn.assignment.util.MyViewModelFactory
import com.dindinn.assignment.ui.main.MainViewModel

@Suppress("unused")
@Module
abstract class ViewModelBuildersModule {

    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}