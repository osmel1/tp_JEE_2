package com.example.tpspring1.service.impls;

import com.example.tpspring1.models.Patient;
import com.example.tpspring1.repository.PatientRepository;
import com.example.tpspring1.service.PatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class implPatientService implements PatService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient ajouterPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> ConsulterTousPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient ConsulterPatient(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> rechercherPatients(String nom) {
        return null;
    }

    @Override
    public void supprimerPatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void modifierPatient(long id, Patient newPatientData) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient existingPatient = patientOptional.get();
            existingPatient.setNom(newPatientData.getNom());
            existingPatient.setDateNaissance(newPatientData.getDateNaissance());
            existingPatient.setMalade(newPatientData.isMalade());
            existingPatient.setScore(newPatientData.getScore());
            patientRepository.save(existingPatient);
        } else {

            throw new RuntimeException("Patient introuvable avec l'ID : " + id);
        }
    }
}
