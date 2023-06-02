package com.example.quizgame.presentation.web_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.common.Resource
import com.example.quizgame.domain.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetLinkViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    private val _linkState = MutableStateFlow<Resource<String>?>(null)
    val linkState : StateFlow<Resource<String>?> = _linkState

    init {
        getLink()
    }

    private fun getLink()
        = viewModelScope.launch {
            _linkState.value = Resource.Loading()
            val link = repository.getLink()
            _linkState.value = link
    }

}