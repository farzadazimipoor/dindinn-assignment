package com.dindinn.assignment.data.local.dto

import com.dindinn.assignment.domain.model.OrderItem

data class OrderItemDto(
    val addon: List<OrderAddOnDto>,
    val alerted_at: String,
    val created_at: String,
    val expired_at: String,
    val id: Int,
    val quantity: Int,
    val title: String,
    val no: String
)

fun OrderItemDto.toOrderItem(): OrderItem {
    return OrderItem(
        addon = addon,
        alerted_at = alerted_at,
        created_at = created_at,
        expired_at = expired_at,
        id = id,
        quantity = quantity,
        title = title,
        no = no
    )
}