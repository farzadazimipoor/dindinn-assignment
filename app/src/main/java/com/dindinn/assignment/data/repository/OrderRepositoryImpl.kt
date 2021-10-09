package com.dindinn.assignment.data.repository

import android.content.Context
import com.dindinn.assignment.data.local.LocalDataService
import com.dindinn.assignment.data.local.dto.toOrderItem
import com.dindinn.assignment.domain.model.OrderItem
import com.dindinn.assignment.domain.repository.OrderRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Orders Repository
 * This class contains all methods that are needed for read orders data
 */
@Singleton
class OrderRepositoryImpl @Inject constructor(
    private val localDataService: LocalDataService
) : OrderRepository {
    override suspend fun getOrders(context: Context): List<OrderItem> {
        return localDataService.getOrdersData(context).data.map { it.toOrderItem() }
    }
}