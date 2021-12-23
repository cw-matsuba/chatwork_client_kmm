package com.example.chatwork_client_kmm.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    @SerialName("account_id") val accountId: Long,
    val name: String,
    @SerialName("avatar_image_url") val avatarImageUrl: String
)
