package com.gorosoft.bookme.now.managers

expect class KMMContext
expect fun KMMContext.putString(key: String, value: String)
expect fun KMMContext.getString(key: String) : String?

expect fun KMMContext.putBool(key: String, value: Boolean)
expect fun KMMContext.getBool(key: String, default: Boolean): Boolean