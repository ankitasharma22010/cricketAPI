package com.example.apirouting.firstOne.Service;

import com.example.apirouting.firstOne.entity.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;


// Don't modify the below code
public class RecipeService implements RecipeRepository {

    private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();

    public RecipeService() {
        recipeBook.put(1,
                new Recipe(1, "Pasta", "veg",
                        Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
        recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
        recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
        recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
        recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
    }

    // Don't modify the above code

    // Write your code here
    @Override
    public ArrayList<Recipe> getRecipe() {
        Collection<Recipe> col = recipeBook.values();
        ArrayList<Recipe> recipe = new ArrayList<>(col);
        return recipe;
    }

    @Override
    public Recipe getRecipeById(int recipeId) {
        Recipe r = recipeBook.get(recipeId);
        if (r == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return r;
    }

    int uniqueId = 6;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipe.setRecipeId(uniqueId);
        recipeBook.put(uniqueId, recipe);
        uniqueId += 1;
        return recipe;
    }

    @Override
    public Recipe updateRecipe(int recipeId, Recipe recipe) {
        Recipe r = recipeBook.get(recipeId);
        if (r == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (recipe.getRecipeName() != null) {
            r.setRecipeName(recipe.getRecipeName());
        }
        if (recipe.getRecipeType() != null) {
            r.setRecipeType(recipe.getRecipeType());
        }
        if (recipe.getIngredients() != null) {
            r.setIngredients(recipe.getIngredients());
        }
        return r;
    }

    @Override
    public void deleteRecipe(int recipeId) {
        Recipe r = recipeBook.get(recipeId);
        if (r == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            recipeBook.remove(recipeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
