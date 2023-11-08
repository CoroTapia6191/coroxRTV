package com.corox.coroxrtv.navigation

sealed class AppScreens(val route: String) {
    object SplashScreen : AppScreens("splash");
    object MainScreen : AppScreens("main");
}