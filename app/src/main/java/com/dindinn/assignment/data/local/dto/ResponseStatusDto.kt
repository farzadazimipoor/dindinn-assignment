package com.dindinn.assignment.data.local.dto

data class ResponseStatusDto(
    val message: String,
    val statusCode: Int,
    val success: Boolean
)