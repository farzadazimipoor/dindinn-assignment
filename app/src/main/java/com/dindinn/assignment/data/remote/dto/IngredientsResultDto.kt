package com.dindinn.assignment.data.remote.dto

data class IngredientsResultDto(
    val data: List<IngredientItemDto>,
    val status: IngredientsResponseStatusDto
)