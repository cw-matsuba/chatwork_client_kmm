package com.example.chatwork_client_kmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chatwork_client_kmm.android.ui.themes.Chatwork_client_kmm_demoTheme
import com.example.chatwork_client_kmm.android.view.RoomListScreen
import com.example.chatwork_client_kmm.android.view.TimelineScreen
import com.example.chatwork_client_kmm.android.viewmodel.RoomListViewModel
import com.example.chatwork_client_kmm.android.viewmodel.TimelineViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chatwork_client_kmm_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "roomList") {
        composable("roomList") {
            val viewModel: RoomListViewModel = viewModel()
            RoomListScreen(navController, viewModel)
        }
        composable(
            "timeline/{roomName}",
            arguments = listOf(navArgument("roomName") { type = NavType.StringType })
        ) {
            val viewModel: TimelineViewModel = viewModel()
            TimelineScreen(viewModel, it.arguments?.getString("roomName") ?: "")
        }
    }
}
