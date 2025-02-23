package com.microservicios.servicioPlatos.repository;

import com.microservicios.servicioPlatos.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Long> {
}
