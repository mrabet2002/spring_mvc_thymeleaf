package ma.enset.jpa_hibernate.repos;

import ma.enset.jpa_hibernate.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
