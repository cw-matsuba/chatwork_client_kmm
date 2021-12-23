package com.example.chatwork_client_kmm

expect class SharedPref

expect fun SharedPref.getString(key: String): String?
expect fun SharedPref.setString(key: String, value: String)
