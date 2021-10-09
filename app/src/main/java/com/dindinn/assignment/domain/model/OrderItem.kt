package com.dindinn.assignment.domain.model

import com.dindinn.assignment.data.local.dto.OrderAddOnDto

data class OrderItem(
    val addon: List<OrderAddOnDto>,
    val alerted_at: String,
    val created_at: String,
    val expired_at: String,
    val id: Int,
    val quantity: Int,
    val title: String
)