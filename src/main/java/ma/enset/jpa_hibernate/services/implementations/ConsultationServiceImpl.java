package ma.enset.jpa_hibernate.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.enset.jpa_hibernate.entities.Consultation;
import ma.enset.jpa_hibernate.repos.ConsultationRepository;
import ma.enset.jpa_hibernate.services.interfaces.IConsultationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements IConsultationService {

    private final ConsultationRepository consultationRepository;

    @Override
    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation getConsultation(Long id) {
        return consultationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Consultation not found")
        );
    }

    @Override
    public void updateConsultation(Long id, Consultation consultation) {
        checkIfConsultationExists(id);
        consultation.setId(id);

        consultationRepository.save(consultation);
    }

    @Override
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public void checkIfConsultationExists(Long id) {
        if (!consultationRepository.existsById(id)) {
            throw new RuntimeException("Consultation not found");
        }
    }
}