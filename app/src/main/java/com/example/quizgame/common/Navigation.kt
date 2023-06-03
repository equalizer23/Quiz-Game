package com.example.quizgame.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.quizgame.presentation.main_screen.MainScreen
import com.example.quizgame.presentation.question_screen.QuestionsScreen
import com.example.quizgame.presentation.result_screen.ResultScreen
import com.example.quizgame.presentation.splash_screen.SplashScreen
import com.example.quizgame.presentation.web_screen.LinkState
import com.example.quizgame.presentation.web_screen.WebScreen
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Constants.SPLASH_ROUTE
    ){

        composable(Constants.SPLASH_ROUTE){
            SplashScreen(navController)
        }
        composable(Constants.QUIZ_ROUTE){
            MainScreen(navController)
        }

        composable(Constants.QUESTIONS_ROUTE){
            QuestionsScreen(navController)
        }

        composable(Constants.WEB_ROUTE) {
            WebScreen()
        }

        composable(
            Constants.RESULT_ROUTE + "/{totalScore}",
        ){
            ResultScreen(
                navHostController = navController,
                correctAnswers = it.arguments?.getString("totalScore")!!.toInt()
            )
        }

    }
}