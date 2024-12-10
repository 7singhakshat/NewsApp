package com.example.newsapp.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.newsapp.presentation.navigation.Routes.CategoryScreen

@Composable
fun HomeScreenUI(modifier: Modifier= Modifier, navController: NavController){
Text(text="Home Screen", modifier= modifier.clickable {


    navController.navigate(CategoryScreen)
})
}