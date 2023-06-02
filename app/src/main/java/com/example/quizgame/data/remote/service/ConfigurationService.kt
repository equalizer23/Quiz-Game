package com.example.quizgame.data.remote.service

interface ConfigurationService {
    suspend fun fetchConfiguration() : Boolean
    val isWebView: Boolean
}