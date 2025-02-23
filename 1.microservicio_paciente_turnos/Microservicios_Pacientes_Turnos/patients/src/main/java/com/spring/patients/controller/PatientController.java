package com.spring.patients.controller;
import com.spring.patients.model.Patient;
import com.spring.patients.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")    // URL en común para todos los endpoints
public class PatientController {
    @Autowired
    private IPatientService ipatients;

    // Test
    @GetMapping("")
    public String testApp(){
        return "Patients app running";
    }
    // GET
    @GetMapping("/get")
    public List<Patient> getPatients(){
        return ipatients.findPatients();
    }

    @GetMapping("/get/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId){
        return ipatients.findPatient(patientId);
    }

    // Get by dni
    @GetMapping("/getByDni/{patientDni}")
    public Patient getPatientByDni(@PathVariable(name = "patientDni") String patientDni){
        return ipatients.findPatientByDni(patientDni);
    }

    // POST
    @PostMapping("/create")
    public String createPatient(@RequestBody Patient patient){
        ipatients.savePatient(patient);
        return "Paciente creado correctamente";
    }
    // PUT
    @PutMapping("/edit/{patientId}")
    public Patient editPatient(@PathVariable Long patientId, @RequestBody Patient patient){
        ipatients.editPatient(patientId, patient);
        return ipatients.findPatient(patientId);
    }
    // DELETE
    @DeleteMapping("/delete/{patientId}")
    public String deletePatient(@PathVariable Long patientId){
        ipatients.deletePatient(patientId);
        return "Paciente eliminado correctamente";
    }

}
