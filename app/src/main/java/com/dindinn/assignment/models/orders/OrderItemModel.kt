package com.dindinn.assignment.models.orders

data class OrderItemModel(
    val addon: List<OrderAddOnModel>,
    val alerted_at: String,
    val created_at: String,
    val expired_at: String,
    val id: Int,
    val quantity: Int,
    val title: String
)