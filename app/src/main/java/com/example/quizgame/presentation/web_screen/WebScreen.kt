package com.example.quizgame.presentation.web_screen

import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quizgame.common.Resource

@Composable
fun WebScreen(
    viewModel: GetLinkViewModel = hiltViewModel()
) {
    val linkState = viewModel.linkState.collectAsState()
    var link: String? = null

    Box(modifier = Modifier.fillMaxSize()){
       when(linkState.value){
           is Resource.Loading ->{
               CircularProgressIndicator(
                   modifier = Modifier.align(Alignment.Center),
                   color = MaterialTheme.colors.primary
               )
           }
           is Resource.Success ->{
               link = (linkState.value as Resource.Success<String>).data.toString()
           }
           is Resource.Error ->{
               Text(
                   text = (linkState.value as Resource.Error<String>).message.toString(),
                   color = MaterialTheme.colors.secondary,
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center
               )
           }
           else -> {

           }
       }

        AndroidView(factory = {context ->
            WebView(context).apply {
                this.settings.javaScriptEnabled = true
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                link?.let{
                    loadUrl(link!!)
                }

            }
        }, update = {webView ->
            link?.let {link ->
                webView.loadUrl(link)
            }
        })
    }

}