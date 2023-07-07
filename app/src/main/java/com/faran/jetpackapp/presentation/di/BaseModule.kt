package com.faran.jetpackapp.presentation.di

import android.app.Application
import android.content.Context
import com.faran.jetpackapp.presentation.JetPackApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): JetPackApplication {
        return app as JetPackApplication
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.baseContext
}