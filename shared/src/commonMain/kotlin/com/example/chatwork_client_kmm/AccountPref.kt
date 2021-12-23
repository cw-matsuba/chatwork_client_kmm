package com.example.chatwork_client_kmm

class AccountPref(private val spf: SharedPref) {
    companion object {
        const val KEY_CHATWORK_TOKEN = "chatwork_token"
    }

    fun setToken(token: String) = spf.setString(KEY_CHATWORK_TOKEN, token)
    fun getToken() = spf.getString(KEY_CHATWORK_TOKEN) ?: ""
    fun isLogin() = getToken().isNotEmpty()
}
