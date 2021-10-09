package com.dindinn.assignment.data.local

import android.content.Context
import android.util.Log
import com.dindinn.assignment.common.Constants
import com.dindinn.assignment.common.Utils
import com.dindinn.assignment.data.local.dto.OrdersResultDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class LocalDataServiceImpl @Inject constructor() : LocalDataService {

    override suspend fun getOrdersData(context: Context): OrdersResultDto {
        try {
            val ordersJsonData = Utils.getJsonDataFromAsset(context, Constants.ORDERS_LIST_FILE_NAME)
            Log.i("data", ordersJsonData ?: "Json data is empty")
            if (ordersJsonData.isNullOrEmpty()) throw Exception("Could not load data")
            val ordersResultType = object : TypeToken<OrdersResultDto>() {}.type
            val result: OrdersResultDto = Gson().fromJson(ordersJsonData, ordersResultType)
            if (result.status.success) return result
            throw Exception(result.status.message)
        } catch (e: Exception) {
            Log.e("ERROR", e.localizedMessage ?: "Error loading orders data")
            throw e
        }
    }
}