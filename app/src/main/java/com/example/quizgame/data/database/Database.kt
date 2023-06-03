package com.example.quizgame.data.database

import com.example.quizgame.common.Constants
import com.example.quizgame.common.await
import com.google.firebase.database.FirebaseDatabase
import java.io.IOException
import javax.inject.Inject

class Database @Inject constructor(
    private val db: FirebaseDatabase
){
    suspend fun getLink() : String{
        val databaseReference = db.getReference(Constants.LINK_REFERENCE)
        val link = databaseReference.get().await()
        return link.value.toString()
    }
}