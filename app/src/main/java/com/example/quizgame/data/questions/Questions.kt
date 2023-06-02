package com.example.quizgame.data.questions

import com.example.quizgame.domain.repositories.models.Question
import com.example.quizgame.R

object Questions {
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium, "Argentina", "Australia",
            "Belgium", "France", 3
        )

        questionList.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany, "Ukraine", "Germany",
            "Belgium", "Austria", 2
        )

        questionList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait, "Egypt", "Israel",
            "New Zealand", "Kuwait", 4
        )

        questionList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand, "Nigeria", "Australia",
            "India", "New Zealand", 4
        )

        questionList.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark, "Denmark", "Finland",
            "Norway", "Sweden", 1
        )

        questionList.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji, "South Korea", "Uzbekistan",
            "Fiji", "Italy", 3
        )

        questionList.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil, "Brazil", "Mexico",
            "Spain", "Portugal", 1
        )

        questionList.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india, "Turkey", "India",
            "Greece", "Moldavia", 2
        )

        questionList.add(que8)

        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, "Argentina", "Austria",
            "Chili", "Peru", 1
        )

        questionList.add(que9)

        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia, "Argentina", "Australia",
            "GreenLand", "Lithuania", 2
        )

        questionList.add(que10)
        return questionList
    }
}