package ma.enset.jpa_hibernate.web;

import lombok.RequiredArgsConstructor;
import ma.enset.jpa_hibernate.entities.Patient;
import ma.enset.jpa_hibernate.services.interfaces.IPatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final IPatientService userService;

    @GetMapping
    public String getPatients(Model model,
                              @RequestParam(defaultValue = "") String kw,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        Page<Patient> patients = userService.searchPatients(kw, page, size);
        model.addAttribute("patients", patients);
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("kw", kw);
        return "patients";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deletePatient(id);
        return "redirect:/patients";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping
    public String add(Model model, @ModelAttribute Patient patient) {
        userService.createPatient(patient);
        return "redirect:/patients";
    }

//    @GetMapping("/{username}")
//    public ResponseEntity<?> getPatient(@PathVariable String username) {
//        try {
//            return ResponseEntity.ok(userService.findPatientByPatientname(username));
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Patient> addPatient(@RequestBody Patient user) {
//        return ResponseEntity.ok(userService.addPatient(user));
//    }

}
