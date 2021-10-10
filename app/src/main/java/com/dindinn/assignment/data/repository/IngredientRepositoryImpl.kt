package com.dindinn.assignment.data.repository

import com.dindinn.assignment.data.remote.DinDinnApiService
import com.dindinn.assignment.data.remote.dto.toIngredientItem
import com.dindinn.assignment.domain.model.IngredientItem
import com.dindinn.assignment.domain.repository.IngredientRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IngredientRepositoryImpl @Inject constructor(
    private val apiService: DinDinnApiService
) : IngredientRepository {
    override suspend fun getIngredients(): List<IngredientItem> {
        return apiService.getIngredients().data.map { it.toIngredientItem() }
    }
}