package com.example.quizgame.data.repositories

import com.example.quizgame.domain.repositories.ConfigurationService
import com.google.firebase.ktx.BuildConfig
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.tasks.await
import com.example.quizgame.R.xml as AppConfig

class ConfigurationServiceImpl : ConfigurationService {
    private val remoteConfig
        get() = Firebase.remoteConfig

    init{
        if(BuildConfig.DEBUG){
            val configSettings = remoteConfigSettings {minimumFetchIntervalInSeconds = 0}
            remoteConfig.setConfigSettingsAsync(configSettings)
        }

        remoteConfig.setDefaultsAsync(AppConfig.remote_config_defaults)
    }

    override suspend fun fetchConfiguration(): Boolean =
        remoteConfig.fetchAndActivate().await()

    override val isWebView: Boolean
        get() = remoteConfig[SHOW_WEB_VIEW].asBoolean()

    companion object{
        private const val SHOW_WEB_VIEW = "WebView"
    }
}