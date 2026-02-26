package com.example.mycity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.mycity.ui.HomeScreen
import com.example.mycity.ui.CategoryScreen
import androidx.navigation.navArgument
import com.example.mycity.ui.DetailScreen
import com.example.mycity.data.DataSource
import com.example.mycity.ui.AboutScreen
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
    ) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        // Home screen
        composable("home") {
            HomeScreen(
                onCategoryClick = { category ->
                    navController.navigate("category/$category")
                }
            )
        }

        // Category screen
        composable("category/{categoryName}") { backStackEntry ->

            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""

            val places = DataSource.getPlacesByCategory(categoryName)

            CategoryScreen(
                category = categoryName,
                places = places,
                onPlaceClick = { place ->
                    navController.navigate("detail/${place.id}")
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = "detail/{placeId}",
            arguments = listOf(
                navArgument("placeId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val placeId = backStackEntry.arguments?.getInt("placeId") ?: 0
            val place = DataSource.getPlaceById(placeId)

            if (place != null) {
                DetailScreen(
                    place = place,
                    onBack = {
                        navController.popBackStack()
                    } ,
                    onOpenMap = {
                        // позже добавим Intent
                    }
                )
            }
        }
        composable("about") {
            AboutScreen()
        }
    }
}