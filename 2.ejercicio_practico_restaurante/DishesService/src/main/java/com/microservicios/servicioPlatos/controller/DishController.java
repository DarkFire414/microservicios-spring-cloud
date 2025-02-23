package com.microservicios.servicioPlatos.controller;

import com.microservicios.servicioPlatos.dto.DishDTO;
import com.microservicios.servicioPlatos.model.Dish;
import com.microservicios.servicioPlatos.service.IDishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private static final Logger logger = LoggerFactory.getLogger(DishController.class);

    @Autowired
    private IDishService iDishService;

    @GetMapping("")
    public ResponseEntity<String> testApp() {
        return new ResponseEntity<>("Dish service running", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Dish>> findAll() {
        return new ResponseEntity<>(iDishService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDish(@RequestBody DishDTO dishDTO) {
        logger.info("DishController.createDish");
        logger.info("dishDTO = {}", dishDTO.toString());
        if (iDishService.save(dishDTO) != null) return new ResponseEntity<>("Plato creado correctamente", HttpStatus.OK);
        else return new ResponseEntity<>("Ocurrió un error al guardar el plato", HttpStatus.CONFLICT);
    }
}
