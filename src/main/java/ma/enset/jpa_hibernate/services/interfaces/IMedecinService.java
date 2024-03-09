package ma.enset.jpa_hibernate.services.interfaces;

import ma.enset.jpa_hibernate.entities.Medecin;
import java.util.List;

public interface IMedecinService {
    List<Medecin> getMedecins();
    Medecin createMedecin(Medecin medecin);
    Medecin getMedecin(Long id);
    void updateMedecin(Long id, Medecin medecin);
    void deleteMedecin(Long id);

    void checkIfMedecinExists(Long id);
}