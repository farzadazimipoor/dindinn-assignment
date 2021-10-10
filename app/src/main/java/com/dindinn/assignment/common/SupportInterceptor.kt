package com.dindinn.assignment.common

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor constructor(val context: Context) : Interceptor {
    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(request)
    }
}