package com.example.quizgame.data.repositories

import android.content.Context
import android.util.Log
import com.example.quizgame.common.Constants
import com.example.quizgame.common.Resource
import com.example.quizgame.common.await
import com.example.quizgame.data.database.Database
import com.example.quizgame.domain.repositories.Repository
import com.google.firebase.database.FirebaseDatabase
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val db: Database
) : Repository{

    override suspend fun getLink() : String {
        return db.getLink()
    }
}