package com.example.quizgame.presentation.splash_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.data.remote.service.ConfigurationService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val configurationService: ConfigurationService
): ViewModel() {

    val option = mutableStateOf(false)

    init {
        viewModelScope.launch {
            configurationService.fetchConfiguration()
        }
    }

    fun loadWebViewOptions(): Boolean {
        option.value = configurationService.isWebView
        return option.value
    }
}