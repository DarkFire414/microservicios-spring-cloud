package com.microservicios.servicioPlatos.model;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "dishes")
@Entity
public class Dish {
    @Column(name = "id_dish")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;
    private String desciption;

    @ElementCollection
    private List<Ingredient> ingredients;
}
