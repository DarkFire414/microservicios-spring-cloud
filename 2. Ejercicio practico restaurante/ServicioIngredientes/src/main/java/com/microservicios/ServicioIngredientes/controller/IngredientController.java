package com.microservicios.ServicioIngredientes.controller;

import com.microservicios.ServicioIngredientes.model.Ingredient;
import com.microservicios.ServicioIngredientes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Funcionamiento
 * Este servicio será consumido por el servicio platos
 * Se necesita devolver los ingredientes que conforman a un plato
 * - Cada ingrediente tiene una serie de nombre de platos asociados
 * - Retornar una lista de ingredientes para un cierto nombr de plato dado
 */
@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/get/{dishName}")
    public ResponseEntity<List<Ingredient>> getByDishName(
            @PathVariable(name = "dishName") String dishName
    ) {
        List<Ingredient> ingredients = this.ingredientService.findByDishName(dishName);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Ingredient>> getAll() {
        List<Ingredient> ingredients = this.ingredientService.findAll();
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient) {
        Ingredient newIngredient = this.ingredientService.save(ingredient);
        return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);
    }

}
