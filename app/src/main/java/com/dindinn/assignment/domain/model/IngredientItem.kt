package com.dindinn.assignment.domain.model

data class IngredientItem(
    val availableCount: Int,
    val categoryId: Int,
    val id: Int,
    val photo: String,
    val title: String
)