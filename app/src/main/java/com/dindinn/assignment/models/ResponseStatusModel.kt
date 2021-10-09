package com.dindinn.assignment.models

data class ResponseStatusModel(
    val message: String,
    val statusCode: Int,
    val success: Boolean
)