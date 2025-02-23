package com.spring.turns.controller;

import com.spring.turns.dto.TurnDTO;
import com.spring.turns.model.Turn;
import com.spring.turns.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/turns")
@RestController
public class TurnController {
    @Autowired
    private ITurnService iturns;

    // Test
    @GetMapping("")
    public String testApp(){
        return "Turns app running";
    }

    // Rest methods
    // Get
    //  Get all
    @GetMapping("/get")
    public List<Turn> getAllTurns(){
        return iturns.findTurns();
    }

    //  Get one by id
    @GetMapping("/get/{turnId}")
    public Turn getTurnById(@PathVariable Long turnId){
        return iturns.findTurnById(turnId);
    }

    // Post
    @PostMapping("/create")
    public String createTurn(@RequestBody TurnDTO turnDTO){
      iturns.saveTurn(turnDTO.getDate(), turnDTO.getTreatment(), turnDTO.getDniPatient());
      return "Turn created";
    }

    // Put
    @PutMapping("/edit/{turnId}")
    public Turn editTurn(@PathVariable Long turnId, @RequestBody Turn turn){
        iturns.editTurn(turnId, turn);
        return iturns.findTurnById(turnId);
    }

    // Delete
    @DeleteMapping("/delete/{turnId}")
    public String deleteTurnById(@PathVariable Long turnId){
        iturns.deleteTurn(turnId);
        return "Turn deleted";
    }
}
