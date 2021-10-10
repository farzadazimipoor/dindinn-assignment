package com.dindinn.assignment.data.remote.dto

import com.dindinn.assignment.domain.model.IngredientItem

data class IngredientItemDto(
    val available_count: Int,
    val category_id: Int,
    val id: Int,
    val photo: String,
    val title: String
)

fun IngredientItemDto.toIngredientItem(): IngredientItem {
    return IngredientItem(
        id = id,
        categoryId = category_id,
        availableCount = available_count,
        photo = photo,
        title = title
    )
}