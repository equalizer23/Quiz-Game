package com.example.quizgame.di

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
        return RepositoryImpl(provideRealtimeDatabase())
    }

}