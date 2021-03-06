package com.example.recipeapp.presentation.ui.recipelist

enum class FoodCategory (val value: String){
    CHICKEN("Chicken"),
    PIZZA("Pizza"),
    BEEF("beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    MILK("Milk"),
    VEGETARIAN("Vegetarian"),
    DONUT("Donut")
}
fun getAllFoodCategories() : List<FoodCategory>{
    return listOf(FoodCategory.CHICKEN,
        FoodCategory.BEEF, FoodCategory.PIZZA, FoodCategory.SOUP,
        FoodCategory.DESSERT, FoodCategory.MILK, FoodCategory.VEGETARIAN, FoodCategory.DONUT
    )
}
fun getFoodCategory(value: String) : FoodCategory?{
    val map = FoodCategory.values().associateBy { FoodCategory :: value }
    return map[value]
}