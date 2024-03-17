package com.example.tpspring1.service;

import com.example.tpspring1.models.Consultation;
import com.example.tpspring1.models.Medecin;
import com.example.tpspring1.models.Patient;
import com.example.tpspring1.models.RendezVous;
import com.example.tpspring1.repository.ConsultationRepository;
import com.example.tpspring1.repository.MedecinRepository;
import com.example.tpspring1.repository.PatientRepository;
import com.example.tpspring1.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private  PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository,
                               ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient enregistrerPatient(Patient patient) {
            return patientRepository.save(patient);
    }

    @Override
    public Medecin enregistrerMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous enregistrerRendezVous(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous)   ;
    }

    @Override
    public Consultation enregistrerConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
