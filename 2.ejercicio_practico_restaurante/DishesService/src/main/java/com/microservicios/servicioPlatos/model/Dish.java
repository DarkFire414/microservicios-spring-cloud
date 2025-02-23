package com.microservicios.servicioPlatos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "dishes")
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dish {
    @Column(name = "id_dish")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> ingredientsNames;
}
