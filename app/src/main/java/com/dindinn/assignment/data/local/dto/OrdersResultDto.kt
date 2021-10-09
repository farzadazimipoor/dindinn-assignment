package com.dindinn.assignment.data.local.dto

data class OrdersResultDto(
    val data: List<OrderItemDto>,
    val status: ResponseStatusDto
)