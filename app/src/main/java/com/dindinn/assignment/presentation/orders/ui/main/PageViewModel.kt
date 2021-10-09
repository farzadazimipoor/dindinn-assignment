package com.dindinn.assignment.presentation.orders.ui.main

import android.content.Context
import androidx.lifecycle.*
import com.dindinn.assignment.common.Resource
import com.dindinn.assignment.domain.model.OrderItem
import com.dindinn.assignment.domain.use_case.order.GetOrdersUseCase
import javax.inject.Inject

class PageViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase
) : ViewModel() {

    private val _index = MutableLiveData<Int>()

    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun fetchOrdersList(context: Context): LiveData<Resource<List<OrderItem>>> {
        return getOrdersUseCase.invoke(context).asLiveData()
    }
}