package com.spring.turns.repository;

import com.spring.turns.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clientsApi", url = "http://localhost:9001/patients")
public interface IPatientsClient {

    @GetMapping("/getByDni/{dniPatient}")
    public Patient getPatientInfo(@PathVariable(name = "dniPatient") String dniPatient);
}
