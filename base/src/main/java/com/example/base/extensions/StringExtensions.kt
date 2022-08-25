package com.example.base.extensions

import android.graphics.Color
import androidx.annotation.ColorInt

fun String?.toInt(defaultValue: Int): Int {
    if (this.isNullOrEmpty()) return defaultValue
    return try {
        this.toInt()
    } catch (exception: Exception) {
        defaultValue
    }
}

@ColorInt
fun String?.parseColor(@ColorInt defaultColor: Int): Int {
    try {
        if (this.isNullOrEmpty()) return defaultColor
        return Color.parseColor(this)
    } catch (exception: Exception) {
    }
    return defaultColor
}

fun String?.toDouble(defaultValue: Double): Double {
    if (this.isNullOrEmpty()) return defaultValue
    return try {
        this.toDouble()
    } catch (exception: Exception) {
        defaultValue
    }
}

fun String?.toFloat(defaultValue: Float): Float {
    if (this.isNullOrEmpty()) return defaultValue
    return try {
        this.toFloat()
    } catch (exception: Exception) {
        defaultValue
    }
}

fun String?.toLong(defaultValue: Long): Long {
    if (this.isNullOrEmpty()) return defaultValue
    return try {
        this.toLong()
    } catch (exception: Exception) {
        defaultValue
    }
}