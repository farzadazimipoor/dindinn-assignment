package com.dindinn.assignment.data.remote

import android.content.Context
import com.dindinn.assignment.common.Constants
import com.dindinn.assignment.common.helpers.LiveDataCallAdapterFactory
import com.dindinn.assignment.common.SupportInterceptor
import com.dindinn.assignment.data.remote.dto.IngredientsResultDto
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface DinDinnApiService {
    @GET("b/6162f1d3aa02be1d44575e65/3")
    suspend fun getIngredients() : IngredientsResultDto

    companion object {
        private fun retrofit(context: Context): Retrofit {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(SupportInterceptor(context))
            httpClient.readTimeout(120, TimeUnit.SECONDS)
            httpClient.connectTimeout(120, TimeUnit.SECONDS)
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .client(httpClient.build())
                .build()
        }

        fun create(context: Context): DinDinnApiService {
            return retrofit(context).create(DinDinnApiService::class.java)
        }
    }
}