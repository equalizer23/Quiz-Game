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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quizgame.R
import com.example.quizgame.common.BackPressSample


@Composable
fun WebScreen(
    viewModel: GetLinkViewModel = hiltViewModel()
) {
    val linkState = viewModel.linkState.value
    Log.e("State", linkState.isLoading.toString())
    val link = linkState.link

    BackPressSample()

    Box(modifier = Modifier.fillMaxSize()){
        if (linkState.error.isNotBlank()){
            Text(
                text = linkState.error,
                color = MaterialTheme.colors.secondary,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.notosans_regular)),
                textAlign = TextAlign.Center
            )
        }

        if(linkState.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                MaterialTheme.colors.primary
            )
        }
        link?.let{
            AndroidView(factory = {context ->
                WebView(context).apply {
                    this.settings.javaScriptEnabled = true
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()

                    loadUrl(link)
                }
            }, update = {webView ->
                webView.loadUrl(link)
            })
        }
    }


}