package com.example.quizgame.common

sealed class BackPress{
    object Idle : BackPress()
    object InitialTouch : BackPress()
}
