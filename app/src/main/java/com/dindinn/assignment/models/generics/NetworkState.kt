package com.dindinn.assignment.models.generics

import com.dindinn.assignment.enums.Status

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
    val status: Status,
    val msg: String? = null
) {
    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.LOADING)
        val UNAUTHORIZED = NetworkState(Status.UNAUTHORIZED)
        val EMPTY_RESULT = NetworkState(Status.EMPTY_RESULT)
        fun error(msg: String?) = NetworkState(Status.ERROR, msg)
    }
}