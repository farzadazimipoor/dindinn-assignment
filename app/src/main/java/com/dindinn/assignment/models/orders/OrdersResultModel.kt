package com.dindinn.assignment.models.orders

import com.dindinn.assignment.models.ResponseStatusModel

data class OrdersResultModel(
    val data: List<OrderItemModel>,
    val status: ResponseStatusModel
)