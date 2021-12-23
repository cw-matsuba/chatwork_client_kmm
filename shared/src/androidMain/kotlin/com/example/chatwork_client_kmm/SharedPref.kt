package com.example.chatwork_client_kmm

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

actual typealias SharedPref = Activity

actual fun SharedPref.getString(key: String): String? {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    return prefs.getString(key, "")
}

actual fun SharedPref.setString(key: String, value: String) {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putString(key, value)
    editor.apply()
}
