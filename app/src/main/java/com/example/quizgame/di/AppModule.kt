package com.example.quizgame.di

import com.example.quizgame.data.database.Database
import com.example.quizgame.domain.repositories.ConfigurationService
import com.example.quizgame.data.repositories.ConfigurationServiceImpl
import com.example.quizgame.data.repositories.RepositoryImpl
import com.example.quizgame.domain.repositories.Repository
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRealtimeDatabase() : FirebaseDatabase
        = FirebaseDatabase.getInstance()

    @Provides
    @Singleton
    fun provideRepository() : Repository{
        return RepositoryImpl(providesDatabase())
    }

    @Provides
    @Singleton
    fun providesConfigurationService(): ConfigurationService {
        return ConfigurationServiceImpl()
    }

    @Provides
    @Singleton
    fun providesDatabase() : Database{
        return Database(provideRealtimeDatabase())
    }
}