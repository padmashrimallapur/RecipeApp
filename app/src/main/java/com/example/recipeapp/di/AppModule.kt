package com.example.recipeapp.di

import android.app.Application
import android.content.Context
import com.example.recipeapp.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context):BaseApplication{
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRandomString(): String{
        return "Hey Look a random String!!!!tfekfkj"
    }
}