package com.gorosoft.bookme.now.managers

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KMMContext

expect fun KMMContext.putString(key: String, value: String?)

expect fun KMMContext.getString(key: String) : String?

expect fun KMMContext.putBool(key: String, value: Boolean)

expect fun KMMContext.getBool(key: String, default: Boolean): Boolean