package com.example.chatwork_client_kmm

import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

actual typealias SharedPref = NSObject

actual fun SharedPref.getString(key: String): String? {
    return NSUserDefaults.standardUserDefaults.stringForKey(key)
}

actual fun SharedPref.setString(key: String, value: String) {
    NSUserDefaults.standardUserDefaults.setString(value, key)
}