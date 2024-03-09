package ma.enset.jpa_hibernate.services.interfaces;

import ma.enset.jpa_hibernate.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService {
    Page<Patient> getPatients(Pageable pageable);
    Page<Patient> searchPatients(String kw, int page, int size);
    Patient createPatient(Patient patient);
    Patient getPatient(Long id);
    void updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
