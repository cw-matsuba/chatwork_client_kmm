package com.example.chatwork_client_kmm.android.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatwork_client_kmm.AccountPref
import com.example.chatwork_client_kmm.ChatworkApi
import com.example.chatwork_client_kmm.android.MyApplication
import com.example.chatwork_client_kmm.model.Room
import kotlinx.coroutines.launch

class RoomListViewModel : ViewModel() {

    private val accountPref: AccountPref = AccountPref(MyApplication.getAppContext())
    val uiState: MutableState<UiState> = mutableStateOf(UiState.Loading)

    init {
        fetchData()
    }

    private fun fetchData() {
        if (accountPref.isLogin()) {
            viewModelScope.launch {
                ChatworkApi().getRooms(accountPref, callback = {
                    uiState.value = UiState.Content(it)
                })
            }
        } else {
            uiState.value = UiState.NoLogin
        }
    }

    fun confirmUser(token: String) {
        uiState.value = UiState.Loading
        accountPref.setToken(token)
        viewModelScope.launch {
            ChatworkApi().getMe(accountPref, callback = {
                fetchData()
            })
        }
    }

    fun logout() {
        accountPref.setToken("")
        uiState.value = UiState.NoLogin
    }

    sealed class UiState {
        object Loading : UiState()
        object NoLogin : UiState()
        data class Content(val roomList: List<Room> = emptyList()) : UiState()
    }
}