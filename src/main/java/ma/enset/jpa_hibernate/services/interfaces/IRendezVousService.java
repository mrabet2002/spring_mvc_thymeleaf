package ma.enset.jpa_hibernate.services.interfaces;

import ma.enset.jpa_hibernate.entities.RendezVous;

import java.util.List;

public interface IRendezVousService {
    List<RendezVous> getRendezVous();
    RendezVous createRendezVous(RendezVous rendezVous);
    RendezVous getRendezVous(Long id);
    void updateRendezVous(Long id, RendezVous rendezVous);
    void deleteRendezVous(Long id);

    void checkIfRendezVousExists(Long id);
}