package com.officegym.liftme.navigation.model

sealed class Screen(val navigationData: NavigationData? = null) {
    abstract fun getScreenPath(): String
    abstract fun getGraphPath(): String

    object Signup : Screen() {
        override fun getScreenPath() = "signUp"
        override fun getGraphPath() = "signUpGraph"
    }
}
