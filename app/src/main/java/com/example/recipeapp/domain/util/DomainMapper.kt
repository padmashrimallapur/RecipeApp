package com.example.recipeapp.domain.util

interface DomainMapper <T, DomainModel>{

    fun mapToDomainModel(Model : T) : DomainModel

    fun mapFromDomainModel(domainModel: DomainModel) : T
}