package com.dindinn.assignment.domain.repository

import android.content.Context
import com.dindinn.assignment.domain.model.OrderItem

interface OrderRepository {
    suspend fun getOrders(context: Context): List<OrderItem>
}