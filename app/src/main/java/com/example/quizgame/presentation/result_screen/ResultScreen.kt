package com.example.quizgame.presentation.result_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizgame.R
import com.example.quizgame.common.Constants
import com.example.quizgame.data.questions.Questions
import com.example.quizgame.presentation.question_screen.components.GifImage

@Composable
fun ResultScreen(
    navHostController: NavHostController,
    correctAnswers: Int
) {
    val questionsSize = Questions.getQuestions().size

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Hey, Congratulations!!!",
                color = MaterialTheme.colors.secondary,
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.notosans_regular)),
                textAlign = TextAlign.Center
            )
            
            GifImage(imageID = R.drawable.tropy_result)
            
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Your score is $correctAnswers of $questionsSize",
                color = MaterialTheme.colors.secondary,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.notosans_regular)),
                textAlign = TextAlign.Center
            )
            
            Button(
                onClick = {
                    navHostController.navigate(Constants.QUIZ_ROUTE){
                        popUpTo(Constants.RESULT_ROUTE){
                            inclusive = true
                        }
                    }
                }
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = "Play Again",
                    color = MaterialTheme.colors.secondary,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}