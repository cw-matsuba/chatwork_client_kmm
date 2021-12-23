package com.example.chatwork_client_kmm.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Room(
    @SerialName("room_id") val roomId: Long,
    val name: String,
    @SerialName("unread_num") val unreadNum: Int,
    @SerialName("icon_path") val iconPath: String,
    @SerialName("last_update_time") val lastUpdateTime: Int
)
