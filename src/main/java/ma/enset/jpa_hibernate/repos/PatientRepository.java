package ma.enset.jpa_hibernate.repos;

import ma.enset.jpa_hibernate.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("select p from Patient p where :kw='' or p.nom like concat('%', :kw, '%') order by p.nom asc")
    Page<Patient> findAllByNomLike(String kw, Pageable pageable);
}
