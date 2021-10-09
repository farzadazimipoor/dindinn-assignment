package com.dindinn.assignment.di

import com.dindinn.assignment.data.local.LocalDataService
import com.dindinn.assignment.data.local.LocalDataServiceImpl
import com.dindinn.assignment.data.repository.OrderRepositoryImpl
import com.dindinn.assignment.domain.repository.OrderRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelBuildersModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideLocalDataService(): LocalDataService {
        return LocalDataServiceImpl()
    }

    @Singleton
    @Provides
    fun provideOrderRepository(localDataService: LocalDataService): OrderRepository {
        return OrderRepositoryImpl(localDataService)
    }
}