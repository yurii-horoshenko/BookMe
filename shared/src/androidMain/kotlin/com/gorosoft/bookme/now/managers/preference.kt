package com.gorosoft.bookme.now.managers

import android.app.Application

const val SP_NAME = "kmm_app"

actual typealias KMMContext = Application
actual fun KMMContext.putString(key: String, value: String) {
    getSpEditor().putString(key, value).apply()
}

actual fun KMMContext.getString(key: String): String? {
    return  getSp().getString(key, null)
}

actual fun KMMContext.putBool(key: String, value: Boolean) {
    getSpEditor().putBoolean(key, value).apply()
}

actual fun KMMContext.getBool(key: String, default: Boolean): Boolean {
    return getSp().getBoolean(key, default)
}

private fun KMMContext.getSp() = getSharedPreferences(SP_NAME, 0)

private fun KMMContext.getSpEditor() = getSp().edit()