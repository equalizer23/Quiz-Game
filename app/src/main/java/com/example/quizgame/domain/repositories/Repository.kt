package com.example.quizgame.domain.repositories

import com.example.quizgame.common.Resource

interface Repository {
    suspend fun getLink(): Resource<String>
}