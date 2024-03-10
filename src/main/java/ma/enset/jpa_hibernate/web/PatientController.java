package ma.enset.jpa_hibernate.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.enset.jpa_hibernate.entities.Patient;
import ma.enset.jpa_hibernate.services.interfaces.IPatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/patients","/"})
@RequiredArgsConstructor
public class PatientController {
    private final IPatientService patientService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String getPatients(Model model,
                              @RequestParam(defaultValue = "") String kw,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        Page<Patient> patients = patientService.searchPatients(kw, page, size);
        model.addAttribute("patients", patients);
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("kw", kw);
        return "patients";
    }

    @GetMapping("delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @GetMapping("add")
    @PreAuthorize("hasRole('ADMIN')")
    public String add(Model model) {
        Patient patient = new Patient();
        patient.setScore(50);
        patient.setMalade(false);
        model.addAttribute("patient", patient);
        return "add-patient";
    }

    @GetMapping("edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("patient", patientService.getPatient(id));
        return "edit-patient";
    }

    @PostMapping("edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(Model model, @PathVariable Long id, @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("patient", patient);
            return "edit-patient";
        }
        patientService.updatePatient(id, patient);
        return "redirect:/patients";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String add(Model model, @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("patient", patient);
            return "add-patient";
        }
        patientService.createPatient(patient);
        return "redirect:/patients";
    }

//    @GetMapping("/{patientname}")
//    public ResponseEntity<?> getPatient(@PathVariable String patientname) {
//        try {
//            return ResponseEntity.ok(patientService.findPatientByPatientname(patientname));
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
//        return ResponseEntity.ok(patientService.addPatient(patient));
//    }

}
