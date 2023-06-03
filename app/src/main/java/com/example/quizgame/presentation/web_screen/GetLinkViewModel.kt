package com.example.quizgame.presentation.web_screen

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.common.Resource
import com.example.quizgame.domain.repositories.Repository
import com.example.quizgame.domain.use_cases.GetLinkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class GetLinkViewModel @Inject constructor(
    private val getLinkUseCase: GetLinkUseCase
) : ViewModel(){

    private val _linkState = mutableStateOf(LinkState())
    val linkState : State<LinkState> = _linkState

    init {
        getLink()
    }
    fun getLink(){
        getLinkUseCase().onEach {
                result ->
            when(result){
                is Resource.Success ->{
                    _linkState.value = LinkState(link = result.data)
                }
                is Resource.Loading ->{
                    _linkState.value = LinkState(isLoading = true)
                }
                else -> {
                    _linkState.value = LinkState(error = result.message?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }


}