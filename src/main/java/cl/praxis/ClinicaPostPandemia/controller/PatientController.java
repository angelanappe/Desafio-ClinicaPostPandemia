package cl.praxis.ClinicaPostPandemia.controller;

import cl.praxis.ClinicaPostPandemia.model.Patient;
import cl.praxis.ClinicaPostPandemia.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String listPatients(Model model) {
        logger.info("Enlistando pacientes hospitalizados...");
        model.addAttribute("patients", patientService.getPatients());
        return "patients";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "createPatient";
    }

    @PostMapping("/create")
    public String createPatient(@ModelAttribute Patient patient){
        patientService.addPatient(patient);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Optional<Patient> patientOptional = patientService.getPatientById(id);
        if (patientOptional.isPresent()) {
            model.addAttribute("patient", patientOptional.get());
        } else {
            return "redirect:/patients";
        }
        return "editPatient";
    }

    @PostMapping("/edit")
    public String editPatient(@ModelAttribute Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/";
    }

}
