package com.example.quizgame.domain.repositories

interface ConfigurationService {
    suspend fun fetchConfiguration() : Boolean
    val isWebView: Boolean
}