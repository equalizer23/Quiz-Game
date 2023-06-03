package com.example.quizgame.presentation.question_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizgame.R
import com.example.quizgame.common.Constants
import com.example.quizgame.data.questions.Questions
import com.example.quizgame.domain.models.Question

@Composable
fun QuestionsScreen(
    navController: NavHostController
) {
    var mCurrentPosition by remember {
        mutableStateOf(0)
    }
    var totalScore by remember {
        mutableStateOf(0)
    }

    var selectedOption by remember {
        mutableStateOf(0)
    }

    val questionList: ArrayList<Question> = Questions.getQuestions()

    var progress by remember {
        mutableStateOf(0.1f)
    }
    val question = questionList[mCurrentPosition]
    val totalQuestions = questionList.size

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
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
                painter = painterResource(id = question.image),
                contentDescription = "Flag"
            )

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.primary
            )

            OutlinedButton(

                onClick = {
                    selectedOption = 1
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary,
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (selectedOption == 1) {
                    BorderStroke(2.dp, color = colorResource(id = R.color.green))
                } else {
                    BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
                }
            ) {
                Text(
                    text = question.optionOne,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }

            OutlinedButton(
                onClick = { selectedOption = 2 },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (selectedOption == 2) {
                    BorderStroke(2.dp, color = colorResource(id = R.color.green))
                } else {
                    BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
                }

            ) {
                Text(
                    text = question.optionTwo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }

            OutlinedButton(
                onClick = { selectedOption = 3 },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (selectedOption == 3) {
                    BorderStroke(2.dp, color = colorResource(id = R.color.green))
                } else {
                    BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
                }

            ) {
                Text(
                    text = question.optionThree,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }

            OutlinedButton(
                onClick = { selectedOption = 4 },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (selectedOption == 4) {
                    BorderStroke(2.dp, color = colorResource(id = R.color.green))
                } else {
                    BorderStroke(1.dp, MaterialTheme.colors.primaryVariant)
                }

            ) {
                Text(
                    text = question.optionFour,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.notosans_regular)),
                    textAlign = TextAlign.Center
                )


            }


            Button(
                onClick = {
                    if (mCurrentPosition + 1 < totalQuestions) {
                        progress += 0.1f
                        mCurrentPosition += 1
                    } else {
                        navController.navigate(Constants.RESULT_ROUTE + "/${totalScore}") {
                            popUpTo(Constants.QUESTIONS_ROUTE) {
                                inclusive = true
                            }
                        }
                    }

                    if (selectedOption == question.correctAnswer) {
                        totalScore += 1
                    }
                    selectedOption = 0
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.secondary
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = selectedOption != 0

            ) {
                Text(
                    text = if (mCurrentPosition < totalQuestions - 1) "Submit" else "Finish",
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

