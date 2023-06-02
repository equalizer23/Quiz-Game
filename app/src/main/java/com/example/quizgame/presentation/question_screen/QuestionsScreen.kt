package com.example.quizgame.presentation.question_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quizgame.R
import com.example.quizgame.common.Constants
import com.example.quizgame.data.questions.Questions
import com.example.quizgame.domain.repositories.models.Question

@Composable
fun QuestionsScreen(
    navController: NavHostController
) {
    var mCurrentPosition: Int = 1
    var totalScore: Int = 0
    var selectedOption: Int = 0
    val questionList: ArrayList<Question> = Questions.getQuestions()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "What country does this flag belong to?",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.notosans_regular)),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_flag_of_belgium),
                contentDescription = "Belgium"
            )
            
            LinearProgressIndicator(progress = mCurrentPosition)

            OutlinedButton(
                onClick = {navController.navigate(Constants.QUESTIONS_ROUTE)},
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)

            ) {
                Text(
                    text = "Start",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }

            OutlinedButton(
                onClick = {navController.navigate(Constants.QUESTIONS_ROUTE)},
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)

            ) {
                Text(
                    text = "Start",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }

            OutlinedButton(
                onClick = {navController.navigate(Constants.QUESTIONS_ROUTE)},
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)

            ) {
                Text(
                    text = "Start",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }

            OutlinedButton(
                onClick = {navController.navigate(Constants.QUESTIONS_ROUTE)},
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)

            ) {
                Text(
                    text = "Start",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }
        }
    }
}