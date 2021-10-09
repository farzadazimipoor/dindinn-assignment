package com.dindinn.assignment.util

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyActivityObserver(
    private val update: () -> Unit
) : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        owner.lifecycle.removeObserver(this)
        update()
    }
}