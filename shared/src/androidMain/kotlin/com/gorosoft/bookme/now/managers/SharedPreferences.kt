package com.gorosoft.bookme.now.managers

import android.annotation.SuppressLint
import android.app.Application
import android.content.SharedPreferences

private const val PREFERENCES_NAME = "book_me_shared_preferences"

private val KMMContext.sharedPref
    get() = getSharedPreferences(PREFERENCES_NAME, Application.MODE_PRIVATE)

actual fun KMMContext.putString(key: String, value: String) {
    sharedPref.edit { putString(key, value).apply() }
}

actual fun KMMContext.getString(key: String): String? {
    return sharedPref.getString(key, null)
}

actual fun KMMContext.putBool(key: String, value: Boolean) {
    sharedPref.edit { putBoolean(key, value).apply() }
}

actual fun KMMContext.getBool(key: String, default: Boolean): Boolean {
    return sharedPref.getBoolean(key, default)
}

@SuppressLint("ApplySharedPref")
private inline fun SharedPreferences.edit(
    commit: Boolean = false,
    action: SharedPreferences.Editor.() -> Unit
) {
    val editor = edit()
    action(editor)
    if (commit) {
        editor.commit()
    } else {
        editor.apply()
    }
}