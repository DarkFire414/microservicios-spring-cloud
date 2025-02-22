package com.spring.turns.service;

import com.spring.turns.model.Patient;
import com.spring.turns.model.Turn;
import com.spring.turns.repository.ITurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnService implements ITurnService{
    @Autowired
    private ITurnRepository iturnr;

    /**
     * Comunicación con otro microservicio
     */
    @Autowired
    private RestTemplate apiConsumption;

    @Override
    public void saveTurn(LocalDate date, String treatment, String dniPatient) {
        // Buscar el paciente en la API pacientes
        Patient pat = apiConsumption.getForObject("http://localhost:9001/patients/getByDni/" + dniPatient, Patient.class);
        // Obtener el nombre completo del paciente
        String completeName = pat.getName() + " " + pat.getLastName();

        Turn newTurn = new Turn();
        newTurn.setDate(date);
        newTurn.setTreatment(treatment);
        newTurn.setPatientName(completeName);

        iturnr.save(newTurn);
    }

    @Override
    public List<Turn> findTurns() {
        return iturnr.findAll();
    }

    @Override
    public Turn findTurnById(Long turnId) {
        return iturnr.findById(turnId).orElse(null);
    }

    @Override
    public void editTurn(Long turnId, Turn turn) {
        Turn originalTurn = this.findTurnById(turnId);
        if (originalTurn != null){
            originalTurn.setDate(turn.getDate());
            originalTurn.setTreatment(turn.getTreatment());
            originalTurn.setPatientName(turn.getPatientName());
            iturnr.save(originalTurn);
        }
    }

    @Override
    public void deleteTurn(Long turnId) {
        iturnr.deleteById(turnId);
    }
}
