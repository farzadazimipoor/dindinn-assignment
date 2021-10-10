package com.dindinn.assignment.di

import android.app.Application
import com.dindinn.assignment.data.local.LocalDataService
import com.dindinn.assignment.data.local.LocalDataServiceImpl
import com.dindinn.assignment.data.remote.DinDinnApiService
import com.dindinn.assignment.data.repository.IngredientRepositoryImpl
import com.dindinn.assignment.data.repository.OrderRepositoryImpl
import com.dindinn.assignment.domain.repository.IngredientRepository
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
    fun provideDinDinnApiService(app: Application): DinDinnApiService {
        return DinDinnApiService.create(app.applicationContext)
    }

    @Singleton
    @Provides
    fun provideOrderRepository(localDataService: LocalDataService): OrderRepository {
        return OrderRepositoryImpl(localDataService)
    }

    @Singleton
    @Provides
    fun provideIngredientRepository(dinnApiService: DinDinnApiService): IngredientRepository {
        return IngredientRepositoryImpl(dinnApiService)
    }
}