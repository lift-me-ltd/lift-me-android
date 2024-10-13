package com.officegym.liftme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.officegym.liftme.navigation.LMNavHost
import com.officegym.liftme.navigation.Navigator
import com.officegym.liftme.navigation.model.Screen
import com.officegym.liftme.ui.theme.LiftMeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController() // should change to rememberAnimatedNavController
            navigator.setNavController(navHostController = navHostController)
            LiftMeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Box(modifier = Modifier.padding(padding)) {
                        LMNavHost(navigator = navigator, Screen.Signup.getScreenPath())
                    }
                }
            }
        }
    }
}
