package com.example.tpspring1.controller;

import com.example.tpspring1.models.Patient;
import com.example.tpspring1.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model ,
                        @RequestParam (name="page",defaultValue = "0") int page,
                        @RequestParam (name="size",defaultValue = "5") int size,
                        @RequestParam (name="keyword",defaultValue = "") String keyword
    ){
        //to get the list of patients with pagination and the keyword
        Page<Patient> patients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patients);
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    //on ajoute le keyword et currentPage pour garder les donnes apres la redirection
    @GetMapping("/delete")
    public String delete(Long id , String keyword , int page) {
        System.out.println("you deleted the patient with id = "+id);
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient", new Patient());
        model.addAttribute("mode", "new");
        return "formPatient";
    }
    @PostMapping("/save")
    public String save(Model model, Patient patient){
        System.out.println(patient.getDateNaissance());
        patientRepository.save(patient);
        return "formPatient";
    }

}
