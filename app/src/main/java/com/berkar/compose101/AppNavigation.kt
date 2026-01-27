package com.berkar.compose101

enum class Screen {
    LOGIN,
    REGISTER
}

sealed class NavigationItem(val route: String) {
    object Login : NavigationItem(Screen.LOGIN.name)
    object Register : NavigationItem(Screen.REGISTER.name)
}