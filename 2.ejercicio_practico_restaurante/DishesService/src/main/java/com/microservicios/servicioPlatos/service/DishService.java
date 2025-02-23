package com.microservicios.servicioPlatos.service;

import com.microservicios.servicioPlatos.dto.DishDTO;
import com.microservicios.servicioPlatos.dto.IngredientDTO;
import com.microservicios.servicioPlatos.model.Dish;
import com.microservicios.servicioPlatos.repository.IDishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class DishService implements IDishService {

    private static final Logger logger = LoggerFactory.getLogger(DishService.class);

    private static final String ingredientServiceURL = "http://localhost:9002/ingredients/get?dishName=";

    @Autowired
    private IDishRepository iDishRepository;

    @Autowired
    private RestTemplate apiConsumption;

    @Override
    public List<Dish> findAll() {
        return iDishRepository.findAll();
    }

    @Override
    public Dish save(DishDTO dishDTO) {
        logger.info("DishService.save");
        logger.info("dishDTO = {}", dishDTO.toString());

        Dish dish = new Dish();
        dish.setName(dishDTO.getName());
        dish.setPrice(dishDTO.getPrice());
        dish.setDescription(dishDTO.getDescription());

        List<String> ingredientsNames = new ArrayList<>();

        // Obtener los ingredientes asociados al nombre del plato
        // desde el servicio de ingredientes
        // Construir la URL con el parámetro de consulta
        String url = ingredientServiceURL + dish.getName();
        logger.info("Service url = {}", url);

        List<IngredientDTO> response = Arrays.asList(Objects.requireNonNull(apiConsumption.getForObject(url, IngredientDTO[].class)));

        logger.info("Service response = {}", response);

        for (IngredientDTO ingredient : response) {
            ingredientsNames.add(ingredient.getName());
        }

        dish.setIngredientsNames(ingredientsNames);

        return iDishRepository.save(dish);
    }
}
