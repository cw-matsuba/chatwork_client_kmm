package com.example.chatwork_client_kmm.android.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatwork_client_kmm.android.ui.compose.AppBar
import com.example.chatwork_client_kmm.android.viewmodel.TimelineViewModel

@Composable
fun TimelineScreen(
    timelineViewModel: TimelineViewModel = viewModel(),
    title: String
) {
    Scaffold(
        topBar = { AppBar(title) }
    ) {

    }
}