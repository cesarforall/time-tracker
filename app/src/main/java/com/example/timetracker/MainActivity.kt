package com.example.timetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timetracker.ui.home.HomeScreen
import com.example.timetracker.ui.record.RecordNewScreen
import com.example.timetracker.ui.theme.TimeTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeTrackerTheme {
                TimeTrackerApp()
            }
        }
    }
}

@Composable
fun TimeTrackerApp() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen( navigateToRecordNew = { navController.navigate("record_new") } )
        }
        composable(route = "record_new") {
            RecordNewScreen(onArrowBackClicked = { navController.popBackStack()})
        }
    }
}