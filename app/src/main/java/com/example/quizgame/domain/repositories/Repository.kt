package com.example.quizgame.domain.repositories

import android.content.Context
import com.example.quizgame.common.Resource

interface Repository {
    suspend fun getLink(): String
}