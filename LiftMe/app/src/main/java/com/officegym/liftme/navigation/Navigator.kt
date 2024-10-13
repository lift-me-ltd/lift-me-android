package com.officegym.liftme.navigation

import androidx.navigation.NavHostController
import com.officegym.liftme.navigation.model.Screen

interface Navigator {
    fun navigate(screen: Screen)
    fun navigateAndPopBackstack(screen: Screen)
    fun popBackStack(popCurrentGraph: Boolean = false): Boolean
    fun setNavController(navHostController: NavHostController)
    fun getNavController(): NavHostController
    fun getStartDestination(): String
}
