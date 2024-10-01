@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.gorosoft.bookme.now.utils

import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

actual typealias KMMContext = NSObject

actual fun KMMContext.putString(key: String, value: String?) {
    NSUserDefaults.standardUserDefaults.setObject(value, key)
}

actual fun KMMContext.getString(key: String): String? {
    return NSUserDefaults.standardUserDefaults.stringForKey(key)
}

actual fun KMMContext.putBool(key: String, value: Boolean) {
    NSUserDefaults.standardUserDefaults.setBool(value, key)
}

actual fun KMMContext.getBool(key: String, default: Boolean): Boolean {
    return NSUserDefaults.standardUserDefaults.boolForKey(key)
}