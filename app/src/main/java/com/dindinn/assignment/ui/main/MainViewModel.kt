package com.dindinn.assignment.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.dindinn.assignment.models.orders.OrderItemModel
import com.dindinn.assignment.repository.OrderRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val orderRepository: OrderRepository) : ViewModel() {
    fun fetchOrdersList(context: Context): List<OrderItemModel> {
        return orderRepository.fetchOrdersList(context)
    }
}