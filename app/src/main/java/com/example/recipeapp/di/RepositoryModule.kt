package com.example.recipeapp.di

import com.example.recipeapp.network.model.RecipeDto
import com.example.recipeapp.network.model.RecipeDtoMapper
import com.example.recipeapp.network.model.retrofit.RecipeService
import com.example.recipeapp.repository.RecipeRepository
import com.example.recipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule  {

    @Singleton
    @Provides
    fun provideRecipeRepository(
         recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ) : RecipeRepository{
        return RecipeRepositoryImpl(
        recipeService = recipeService,
          recipeDtoMapper
         )
    }
}