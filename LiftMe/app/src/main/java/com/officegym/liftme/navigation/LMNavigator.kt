package com.officegym.liftme.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.officegym.liftme.navigation.model.Screen

class LMNavigator: Navigator {
    private lateinit var navHostController: NavHostController

    @Suppress("LongMethod", "CyclomaticComplexMethod")
    override fun navigate(screen: Screen) {
        when (screen) {
            Screen.Signup -> {
                navHostController.navigate(
                    screen.getGraphPath(),
                )
            }
        }
    }

    override fun navigateAndPopBackstack(screen: Screen) {
        navHostController.currentBackStackEntry?.destination?.parent?.id?.let { parentGraph ->
            navHostController.navigate(
                route = screen.getScreenPath(),
                navOptions = navOptions {
                    popUpTo(
                        id = parentGraph,
                        popUpToBuilder = { inclusive = true }
                    )
                    launchSingleTop = true
                }
            )
        }
    }

    override fun popBackStack(popCurrentGraph: Boolean): Boolean {
        return if (popCurrentGraph) {
            navHostController.currentBackStackEntry?.destination?.parent?.id?.let {
                navHostController.popBackStack(it, true)
            } ?: true
        } else {
            navHostController.navigateUp()
        }
    }

    override fun setNavController(navHostController: NavHostController) {
        this.navHostController = navHostController
    }

    override fun getNavController(): NavHostController = navHostController

    override fun getStartDestination(): String = Screen.Signup.getGraphPath()
}

@Suppress("UnusedPrivateMember")
private fun NavHostController.createPopUpToInclusive(): NavOptions? {
    return currentBackStackEntry?.destination?.route
        ?.let { route ->
            navOptions {
                popUpTo(route) {
                    inclusive = true
                }
            }
        }
}

private fun NavHostController.createPopUpToAndRemoveBackstack(): NavOptions? {
    return currentBackStackEntry?.destination?.route
        ?.let { _ ->
            navOptions {
                popUpTo(0)
                launchSingleTop = true
                restoreState = true
            }
        }
}
