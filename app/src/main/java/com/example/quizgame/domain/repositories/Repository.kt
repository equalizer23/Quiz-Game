package com.example.quizgame.domain.repositories

import com.example.quizgame.common.Resource
import com.example.quizgame.domain.models.Link

interface Repository {
    suspend fun getLink(): Resource<String>
}