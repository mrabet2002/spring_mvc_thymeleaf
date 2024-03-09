package ma.enset.jpa_hibernate.services.interfaces;

import ma.enset.jpa_hibernate.entities.Consultation;
import java.util.List;

public interface IConsultationService {
    List<Consultation> getConsultations();
    Consultation createConsultation(Consultation consultation);
    Consultation getConsultation(Long id);
    void updateConsultation(Long id, Consultation consultation);
    void deleteConsultation(Long id);

    void checkIfConsultationExists(Long id);
}