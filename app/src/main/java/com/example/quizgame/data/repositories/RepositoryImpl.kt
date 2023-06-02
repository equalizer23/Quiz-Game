package com.example.quizgame.data.repositories

import android.util.Log
import com.example.quizgame.common.Resource
import com.example.quizgame.common.await
import com.example.quizgame.domain.repositories.Repository
import com.google.firebase.database.FirebaseDatabase
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val db: FirebaseDatabase
) : Repository{

    override suspend fun getLink() : Resource<String>{
        return try{
            val databaseReference = db.getReference("Link")
            val link = databaseReference.get().await()
            Resource.Success(link.value.toString())
        }
        catch (e: Exception){
            e.printStackTrace()
            Log.e("error", e.localizedMessage!!)
            Resource.Error(e.localizedMessage?: "An unexpected error occurred")
        }
        catch (e: IOException){
            e.printStackTrace()
            Log.e("error", e.localizedMessage!!)
            Resource.Error(e.localizedMessage?: "Couldn't reach server. Check your internet connection")
        }
    }
}