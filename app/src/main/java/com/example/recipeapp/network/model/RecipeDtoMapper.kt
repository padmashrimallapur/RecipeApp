package com.example.recipeapp.network.model

import com.example.recipeapp.domain.Recipe
import com.example.recipeapp.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(entity: RecipeDto): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating =  entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.source_url,
            description =  entity.description,
            cookingInstruction = entity.cooking_instructions,
            ingredients = entity.ingredients.orEmpty(),
            dateAdded = entity.date_added,
            dateUpdater = entity.date_updated,
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
       return RecipeDto(

           pk = domainModel.id,
           title = domainModel.title,
           featuredImage = domainModel.featuredImage,
           rating =  domainModel.rating,
           publisher = domainModel.publisher,
           source_url = domainModel.sourceUrl,
           description =  domainModel.description,
           cooking_instructions = domainModel.cookingInstruction,
           ingredients = domainModel.ingredients,
           date_added = domainModel.dateAdded,
           date_updated = domainModel.dateUpdater,
       )
    }

    fun toDomainList(initial : List<RecipeDto>) : List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(intial : List<Recipe>) : List<RecipeDto>{
        return intial.map { mapFromDomainModel(it) }
    }
}