package com.example.newsapp.presentation.navigation.Routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.NewsAppViewModel
import com.example.newsapp.presentation.screens.CategoryDeatiledNews
import com.example.newsapp.presentation.screens.HomeScreenUI

@Composable
fun AppNavigation(modifier: Modifier = Modifier, viewModel: NewsAppViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> { HomeScreenUI(navController = navController, viewModel = viewModel) }
        composable<CategoryScreen> { CategoryDeatiledNews() }
    }


}