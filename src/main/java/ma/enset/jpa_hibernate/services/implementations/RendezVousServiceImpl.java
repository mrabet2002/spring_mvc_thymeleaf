package ma.enset.jpa_hibernate.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.enset.jpa_hibernate.entities.RendezVous;
import ma.enset.jpa_hibernate.repos.RendezVousRepository;
import ma.enset.jpa_hibernate.services.interfaces.IRendezVousService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RendezVousServiceImpl implements IRendezVousService {

    private final RendezVousRepository rendezVousRepository;

    @Override
    public List<RendezVous> getRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous createRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous getRendezVous(Long id) {
        return rendezVousRepository.findById(id).orElseThrow(
                () -> new RuntimeException("RendezVous not found")
        );
    }

    @Override
    public void updateRendezVous(Long id, RendezVous rendezVous) {
        checkIfRendezVousExists(id);
        rendezVous.setId(id);

        rendezVousRepository.save(rendezVous);
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public void checkIfRendezVousExists(Long id) {
        if (!rendezVousRepository.existsById(id)) {
            throw new RuntimeException("RendezVous not found");
        }
    }
}