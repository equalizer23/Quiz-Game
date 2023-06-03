package com.example.quizgame.presentation.web_screen


data class LinkState(
    val link: String? = null,
    val error: String = "",
    val isLoading: Boolean = false
)