package com.example.quizgame.domain.use_cases

import android.content.Context
import com.example.quizgame.common.Resource
import com.example.quizgame.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetLinkUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() : Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            val link = repository.getLink()
            emit(Resource.Success(link))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }
}