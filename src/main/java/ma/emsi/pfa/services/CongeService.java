package ma.emsi.pfa.services;

import ma.emsi.pfa.entities.Conge;
import ma.emsi.pfa.repositories.CongeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CongeService {
    private final CongeRepository congeRepository;

    public CongeService(CongeRepository congeRepository) {
        this.congeRepository = congeRepository;
    }

    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    public Optional<Conge> getCongeById(Long id) {
        return congeRepository.findById(id);
    }

    public Conge createConge(Conge conge) {
        return congeRepository.save(conge);
    }

    public Conge updateConge(Long id, Conge updatedConge) {
        Optional<Conge> existingConge = congeRepository.findById(id);
        if (existingConge.isPresent()) {
            Conge congeToUpdate = existingConge.get();
            congeToUpdate.setDate_envoi(updatedConge.getDate_envoi());
            congeToUpdate.setPeriode(updatedConge.getPeriode());
            congeToUpdate.setDate_debut(updatedConge.getDate_debut());
            congeToUpdate.setFichier_just(updatedConge.getFichier_just());
            congeToUpdate.setAvis(updatedConge.getAvis());
            congeToUpdate.setRais_avis(updatedConge.getRais_avis());
            congeToUpdate.setDate_avis(updatedConge.getDate_avis());
            return congeRepository.save(congeToUpdate);
        } else {
            return null;
        }
    }

    public void deleteConge(Long id) {
        congeRepository.deleteById(id);
    }
}
