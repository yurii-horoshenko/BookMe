package com.gorosoft.bookme.now.utils

class KMMPreference(private val context: KMMContext) {
    fun put(key: String, value: String) {
        context.putString(key, value)
    }

    fun put(key: String, value: Boolean) {
        context.putBool(key, value)
    }

    fun getString(key: String): String? =
        context.getString(key)

    fun getBool(key: String, default: Boolean): Boolean =
        context.getBool(key, default)
}
