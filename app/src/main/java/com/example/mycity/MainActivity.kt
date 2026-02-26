package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.navigation.AppNavGraph
import com.example.mycity.ui.AdaptiveLayout
import com.example.mycity.navigation.BottomNavItem
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mycity.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    NavigationBar {
                        val items = listOf(
                            BottomNavItem.Home,
                            BottomNavItem.Categories,
                            BottomNavItem.About
                        )

                        val currentRoute =
                            navController.currentBackStackEntryAsState().value?.destination?.route

                        items.forEach { item ->
                            NavigationBarItem(
                                selected = currentRoute == item.route,
                                onClick = {
                                    navController.navigate(item.route) {
                                        popUpTo("home")
                                        launchSingleTop = true
                                    }
                                },
                                icon = { Icon(item.icon, contentDescription = item.title) },
                                label = { Text(item.title) }
                            )
                        }
                    }
                }
            ) { padding ->
                AppNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }
}

