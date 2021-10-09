package com.dindinn.assignment.util

import android.graphics.Insets
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity

object Utils {
    fun getWindowHeight(activity: AppCompatActivity): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = activity.windowManager.currentWindowMetrics
            val insets: Insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.height() - insets.top - insets.bottom
        } else {
            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.heightPixels
        }
    }
}