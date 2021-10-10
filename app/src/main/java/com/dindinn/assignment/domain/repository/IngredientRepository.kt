package com.dindinn.assignment.domain.repository

import com.dindinn.assignment.domain.model.IngredientItem

interface IngredientRepository {
    suspend fun getIngredients(): List<IngredientItem>
}