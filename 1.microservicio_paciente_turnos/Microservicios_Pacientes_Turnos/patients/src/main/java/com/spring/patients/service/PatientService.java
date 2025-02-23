package com.spring.patients.service;
import com.spring.patients.model.Patient;
import com.spring.patients.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService implements IPatientService{
    @Autowired
    private IPatientRepository ipatientr;

    @Override
    public void savePatient(Patient patient) {
        ipatientr.save(patient);
    }

    @Override
    public List<Patient> findPatients() {
        return ipatientr.findAll();
    }

    @Override
    public Patient findPatient(Long patientId) {
        return ipatientr.findById(patientId).orElse(null);
    }

    @Override
    public Patient findPatientByDni(String dni) {
        return ipatientr.findByDni(dni);
    }

    @Override
    public void editPatient(Long patientId, Patient patient) {
        Patient pt = this.findPatient(patientId);
        if (pt != null){
            pt.setPatientId(patientId);
            pt.setName(patient.getName());
            pt.setLastName(patient.getLastName());
            pt.setDni(patient.getDni());
            pt.setBirthDate(patient.getBirthDate());
            pt.setPhoneNumber(patient.getPhoneNumber());
            this.savePatient(pt);
        }
    }

    @Override
    public void deletePatient(Long patientId) {
        ipatientr.deleteById(patientId);
    }
}
