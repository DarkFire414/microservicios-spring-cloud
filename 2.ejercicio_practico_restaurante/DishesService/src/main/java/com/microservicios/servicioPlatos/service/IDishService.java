package com.microservicios.servicioPlatos.service;

import com.microservicios.servicioPlatos.dto.DishDTO;
import com.microservicios.servicioPlatos.model.Dish;

import java.util.List;

public interface IDishService {
    List<Dish> findAll();

    Dish save(DishDTO dishDTO);
}
