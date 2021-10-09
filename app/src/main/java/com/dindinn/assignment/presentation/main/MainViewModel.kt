package com.dindinn.assignment.presentation.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dindinn.assignment.common.Resource
import com.dindinn.assignment.domain.model.OrderItem
import com.dindinn.assignment.domain.use_case.order.GetOrdersUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase
) : ViewModel() {
    fun fetchOrdersList(context: Context): LiveData<Resource<List<OrderItem>>> {
        return getOrdersUseCase.invoke(context).asLiveData()
    }
}