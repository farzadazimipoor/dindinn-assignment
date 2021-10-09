package com.dindinn.assignment.data.local

import android.content.Context
import com.dindinn.assignment.data.local.dto.OrdersResultDto

interface LocalDataService {
    suspend fun getOrdersData(context: Context): OrdersResultDto
}