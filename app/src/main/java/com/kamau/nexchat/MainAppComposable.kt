package com.kamau.nexchat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.kamau.nexchat.feature.auth.signin.SignInScreen
import com.kamau.nexchat.feature.auth.signup.SignUpScreen
import com.kamau.nexchat.feature.home.HomeScreen

@Composable
fun MainApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val navController = rememberNavController()
        val currentUser = FirebaseAuth.getInstance().currentUser
         val start = if (currentUser != null) "home" else "login"
        NavHost(navController = navController, startDestination = start){
            composable("login"){
                SignInScreen(navController)
            }
            composable("signup"){
                SignUpScreen(navController)
            }
            composable("home"){
                HomeScreen(navController)
            }
    }

}
}