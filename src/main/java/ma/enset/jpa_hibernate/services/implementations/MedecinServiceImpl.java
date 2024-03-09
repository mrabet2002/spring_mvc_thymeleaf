package ma.enset.jpa_hibernate.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.enset.jpa_hibernate.entities.Medecin;
import ma.enset.jpa_hibernate.repos.MedecinRepository;
import ma.enset.jpa_hibernate.services.interfaces.IMedecinService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedecinServiceImpl implements IMedecinService {

    private final MedecinRepository medecinRepository;

    @Override
    public List<Medecin> getMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin createMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin getMedecin(Long id) {
        return medecinRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Medecin not found")
        );
    }

    @Override
    public void updateMedecin(Long id, Medecin medecin) {
        checkIfMedecinExists(id);
        medecin.setId(id);

        medecinRepository.save(medecin);
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public void checkIfMedecinExists(Long id) {
        if (!medecinRepository.existsById(id)) {
            throw new RuntimeException("Medecin not found");
        }
    }
}