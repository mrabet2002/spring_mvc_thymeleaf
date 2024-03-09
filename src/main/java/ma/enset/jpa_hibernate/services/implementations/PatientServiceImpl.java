package ma.enset.jpa_hibernate.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.enset.jpa_hibernate.entities.Patient;
import ma.enset.jpa_hibernate.repos.PatientRepository;
import ma.enset.jpa_hibernate.services.interfaces.IPatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;

    @Override
    public Page<Patient> getPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Page<Patient> searchPatients(String kw, int page, int size) {
        return patientRepository.findAllByNomLike(kw, PageRequest.of(page, size));
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Patient not found")
        );
    }

    @Override
    public void updatePatient(Long id, Patient patient) {
        checkIfPatientExists(id);
        patient.setId(id);

        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    private void checkIfPatientExists(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found");
        }
    }
}
