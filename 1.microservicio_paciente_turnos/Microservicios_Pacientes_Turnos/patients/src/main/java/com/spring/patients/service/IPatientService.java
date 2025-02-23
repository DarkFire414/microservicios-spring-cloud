package com.spring.patients.service;
import com.spring.patients.model.Patient;
import java.util.List;

public interface IPatientService {
    // CRUD Operations
    // Create
    public void savePatient(Patient patient);
    // Read all
    public List<Patient> findPatients();
    // Read one
    public Patient findPatient(Long patientId);
    // Read by
    public Patient findPatientByDni(String dni);
    // Update
    public void editPatient(Long patientId, Patient patient);
    // Delete
    public void deletePatient(Long patientId);
}
