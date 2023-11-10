package com.corox.coroxrtv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.corox.coroxrtv.ui.SplashScreen
import com.corox.coroxrtv.ui.MainScreen
import com.corox.coroxrtv.ui.MainViewModel

@Composable
fun AppNavigation(mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route ){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController,mainViewModel)
        }
        composable(AppScreens.MainScreen.route){
            MainScreen(mainViewModel)
        }
    }

}