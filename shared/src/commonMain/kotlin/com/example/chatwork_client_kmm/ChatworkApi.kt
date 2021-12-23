package com.example.chatwork_client_kmm

import com.example.chatwork_client_kmm.model.Account
import com.example.chatwork_client_kmm.model.Room
import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChatworkApi {
    val apiClient: ChatworkApiClient = ChatworkApiClient()
    companion object {
        private const val BASE_URL = "https://api.chatwork.com"
    }

    fun getRooms(accountPref: AccountPref, callback: (List<Room>) -> Unit) {
        GlobalScope.apply {
            launch(apiClient.dispatcher) {
                val result = apiClient.client.get<List<Room>>("$BASE_URL/v2/rooms") {
                    header("X-ChatWorkToken", accountPref.getToken())
                }
                callback(result)
            }
        }
    }

    fun getMe(accountPref: AccountPref, callback: (Account) -> Unit) {
        GlobalScope.apply {
            launch(apiClient.dispatcher) {
                val result = apiClient.client.get<Account>("$BASE_URL/v2/me") {
                    header("X-ChatWorkToken", accountPref.getToken())
                }
                callback(result)
            }
        }
    }
}
