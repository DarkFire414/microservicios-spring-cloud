package com.microservicios.ServicioIngredientes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// Lombok Ann
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "ingredients")
@Entity
public class Ingredient {
    @Column(name = "id_ingredient")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name_ingredient")
    private String name;

    @ElementCollection
    private List<String> dishName;
}
