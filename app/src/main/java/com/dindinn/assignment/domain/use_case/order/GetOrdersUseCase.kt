package com.dindinn.assignment.domain.use_case.order

import android.content.Context
import com.dindinn.assignment.common.Resource
import com.dindinn.assignment.domain.model.OrderItem
import com.dindinn.assignment.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOrdersUseCase @Inject constructor(
    private val repository: OrderRepository
) {
    operator fun invoke(context: Context): Flow<Resource<List<OrderItem>>> = flow {
        try {
            emit(Resource.loading(data = null))
            val orders = repository.getOrders(context)
            emit(Resource.success(data = orders))
        } catch (e: Exception) {
            emit(Resource.error(msg = e.localizedMessage ?: "", data = null))
        }
    }
}