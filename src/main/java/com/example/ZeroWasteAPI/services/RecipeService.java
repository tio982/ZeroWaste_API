package com.example.ZeroWasteAPI.services;

import com.example.ZeroWasteAPI.models.Recipe;
import com.example.ZeroWasteAPI.repositories.IngredientRepository;
import com.example.ZeroWasteAPI.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(long id) {
        return recipeRepository.findById(id).get();
    }

    public Recipe addNewRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }


    public Recipe updateRecipe(Recipe recipe, Long id) {
        //Find recipe, add by id
        Recipe recipeToUpdate = recipeRepository.findById(id).get();
        //Take each property and update it
        recipeToUpdate.setName(recipe.getName());
        recipeToUpdate.setDescription(recipe.getDescription());
        recipeToUpdate.setCookingTime(recipe.getCookingTime());
        recipeToUpdate.setServings(recipe.getServings());
        recipeToUpdate.setMethod(recipe.getMethod());
        recipeToUpdate.setIngredients(recipe.getIngredients());

        //Save recipe to database


        //Return the recipe

        recipeRepository.save(recipeToUpdate);
        return recipeToUpdate;
    }

    //DELETE recipe
    public void deleteRecipe(Long id) {
    Recipe recipeToDelete = recipeRepository.findById(id).get();
    recipeToDelete.setId(recipeToDelete.getId());

    recipeRepository.delete(recipeToDelete);
    }
}
