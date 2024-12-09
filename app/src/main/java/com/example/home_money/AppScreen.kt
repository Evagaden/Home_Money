package com.example.home_money

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.home_money.forgotpwscreen.ForgotPwScreen
import com.example.home_money.homescreen.HomeScreen
import com.example.home_money.mainscreen.MainScreen
import com.example.home_money.signinscreen.ForgetPassword
import com.example.home_money.signinscreen.SignInScreen
import com.example.home_money.signupscreen.SignUpScreen

enum class AppScreen(){
    main_screen, sign_in_screen, sign_up_screen, forgot_pw_screen,
    home_screen, fund_screen, add_screen, report_screen, etc_screen
}

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.main_screen.name,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(
                route = AppScreen.main_screen.name,
                content = {
                    MainScreen(
                        onSignInButtonTapped = {navController.navigate(AppScreen.sign_in_screen.name)},
                        onSignUpButtonTapped = {navController.navigate(AppScreen.sign_up_screen.name)},
                        modifier = Modifier.padding(innerPadding))
                }
            )
            composable(
                route = AppScreen.sign_in_screen.name,
                content = {
                    SignInScreen(
                        onSignInButton2Tapped = {navController.navigate(AppScreen.home_screen.name)},
                        onSignUpButton2Tapped = {navController.navigate(AppScreen.sign_up_screen.name)},
                        onForgetPasswordTapped = {navController.navigate(AppScreen.forgot_pw_screen.name)},
                        modifier = Modifier.padding(innerPadding))

                }
            )
            composable(
                route = AppScreen.sign_up_screen.name,
                content = {
                    SignUpScreen(
                        onSignUpButton3Tapped = {navController.navigate(AppScreen.home_screen.name)},
                        modifier = Modifier.padding(innerPadding))
                }
            )
            composable(
                route = AppScreen.forgot_pw_screen.name,
                content = {
                    ForgotPwScreen(
                        onSendNewpwButtonTapped = {navController.navigate(AppScreen.home_screen.name)},
                        modifier = Modifier.padding(innerPadding))
                }
            )
            composable(
                route = AppScreen.home_screen.name,
                content = { HomeScreen() }
            )
        }
    }
}