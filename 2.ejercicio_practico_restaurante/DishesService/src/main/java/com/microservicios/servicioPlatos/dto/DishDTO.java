package com.microservicios.servicioPlatos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class DishDTO {
    private String name;
    private Double price;
    private String description;

    @Override
    public String toString() {
        return "DishDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
