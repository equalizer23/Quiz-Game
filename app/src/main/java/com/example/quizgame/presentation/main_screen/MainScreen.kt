package com.example.quizgame.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quizgame.R
import com.example.quizgame.common.Constants

@Composable
fun MainScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 20.dp)
            .background(color = MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Welcome to Quizyy",
                color = MaterialTheme.colors.secondary,
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.notosans_regular, FontWeight.Bold)),
                textAlign = TextAlign.Center
            )

            OutlinedButton(
                onClick = {navController.navigate(Constants.QUESTIONS_ROUTE)},
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(
                    text = "Start",
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }
        }
    }
}