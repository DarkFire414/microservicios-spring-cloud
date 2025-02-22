package com.microservicios.ServicioIngredientes.repository;

import com.microservicios.ServicioIngredientes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    /*
    SELECT ingredients.id_ingredient, ingredients.name_ingredient
    FROM ingredient_dish_name
    JOIN ingredients
	    ON ingredients.id_ingredient = ingredient_dish_name.ingredient_id_ingredient
    WHERE ingredient_dish_name.dish_name = "Chilaquiles";
     */

    @Query("SELECT ingr FROM Ingredient ingr WHERE :dishName MEMBER OF ingr.dishName")
    List<Ingredient> findByDishName(@Param("dishName") String dishName);
}
