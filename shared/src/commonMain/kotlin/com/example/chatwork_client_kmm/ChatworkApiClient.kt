package com.example.chatwork_client_kmm

import io.ktor.client.*
import kotlinx.coroutines.CoroutineDispatcher

expect class ChatworkApiClient() {
    val client: HttpClient
    val dispatcher: CoroutineDispatcher
}