package com.example.apirouting.firstOne.Service;


import com.example.apirouting.firstOne.entity.Recipe;

import java.util.ArrayList;


public interface RecipeRepository {
    ArrayList<Recipe> getRecipe();

    Recipe getRecipeById(int recipeId);

    Recipe addRecipe(Recipe recipe);

    Recipe updateRecipe(int recipeId, Recipe recipe);

    void deleteRecipe(int recipeId);
}
