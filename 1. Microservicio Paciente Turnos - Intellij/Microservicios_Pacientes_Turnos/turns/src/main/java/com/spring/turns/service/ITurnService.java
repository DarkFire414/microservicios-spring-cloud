package com.spring.turns.service;

import com.spring.turns.model.Turn;

import java.time.LocalDate;
import java.util.List;

public interface ITurnService {
    // CRUD Operations
    // Create
    public void saveTurn(LocalDate date, String treatment, String dniPatient);
    // Read all
    public List<Turn> findTurns();
    // Read one
    public Turn findTurnById(Long turnId);
    // Update
    public void editTurn(Long turnId, Turn turn);
    // Delete
    public void deleteTurn(Long turnId);
}
