package com.dindinn.assignment.repository

import android.content.Context
import android.util.Log
import com.dindinn.assignment.models.orders.OrderItemModel
import com.dindinn.assignment.models.orders.OrdersResultModel
import com.dindinn.assignment.util.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderRepository @Inject constructor() {
    fun fetchOrdersList(context: Context): List<OrderItemModel> {
        val ordersJsonData = Utils.getJsonDataFromAsset(context, "orders.json")
        Log.i("data", ordersJsonData ?: "Json data is empty")
        if (ordersJsonData.isNullOrEmpty()) return listOf()
        val ordersResultType = object : TypeToken<OrdersResultModel>() {}.type
        val result: OrdersResultModel = Gson().fromJson(ordersJsonData, ordersResultType)
        if (result.status.success) {
            return result.data
        } else throw Exception(result.status.message)
    }
}