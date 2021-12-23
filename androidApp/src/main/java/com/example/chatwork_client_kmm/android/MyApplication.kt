package com.example.chatwork_client_kmm.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context
        fun getAppContext(): Context = context
    }
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}
