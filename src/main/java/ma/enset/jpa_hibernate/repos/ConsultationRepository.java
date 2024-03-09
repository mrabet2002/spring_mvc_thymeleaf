package ma.enset.jpa_hibernate.repos;

import ma.enset.jpa_hibernate.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
