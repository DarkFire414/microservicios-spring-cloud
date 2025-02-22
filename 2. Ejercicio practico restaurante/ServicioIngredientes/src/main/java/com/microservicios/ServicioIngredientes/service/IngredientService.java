package com.microservicios.ServicioIngredientes.service;

import com.microservicios.ServicioIngredientes.model.Ingredient;
import com.microservicios.ServicioIngredientes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    // Save
    public Ingredient save(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    // Get all
    public List<Ingredient> findAll() {
        return this.ingredientRepository.findAll();
    }

    // Get by id
    public Ingredient findById(Long id) {
        return this.ingredientRepository.findById(id).orElse(null);
    }

    public List<Ingredient> findByDishName(String dishName) {
        return this.ingredientRepository.findByDishName(dishName);
    }
}
