package ma.emsi.pfa.services;

import ma.emsi.pfa.entities.Departement;
import ma.emsi.pfa.repositories.DepartementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartementService {
    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Optional<Departement> getDepartementById(Long id) {
        return departementRepository.findById(id);
    }

    public Departement createDepartement(Departement departement) {
        // Add validation or business logic if needed
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(Long id, Departement updatedDepartement) {
        Optional<Departement> existingDepartement = departementRepository.findById(id);
        if (existingDepartement.isPresent()) {
            Departement departementToUpdate = existingDepartement.get();
            departementToUpdate.setNom(updatedDepartement.getNom());
            return departementRepository.save(departementToUpdate);
        } else {
            return null;
        }
    }

    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }
}
