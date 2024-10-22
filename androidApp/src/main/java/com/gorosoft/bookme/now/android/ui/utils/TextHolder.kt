package com.gorosoft.bookme.now.android.ui.utils

import android.content.Context

sealed class TextHolder {
    data class Text(val value: String) : TextHolder()
    data class Resource(val resId: Int) : TextHolder()

    fun getText(context: Context): String = when (this) {
        is Text -> value
        is Resource -> context.getString(resId)
    }
}
