package ma.emsi.pfa.services;

import ma.emsi.pfa.entities.Absence;
import ma.emsi.pfa.repositories.AbsenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AbsenceService {
    private final AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    public Optional<Absence> getAbsenceById(Long id) {
        return absenceRepository.findById(id);
    }

    public Absence createAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    public Absence updateAbsence(Long id, Absence updatedAbsence) {
        Optional<Absence> existingAbsence = absenceRepository.findById(id);
        if (existingAbsence.isPresent()) {
            // Update Absence
            Absence absenceToUpdate = existingAbsence.get();
            absenceToUpdate.setDate_absence(updatedAbsence.getDate_absence());
            absenceToUpdate.setNb_jour(updatedAbsence.getNb_jour());
            absenceToUpdate.setJustifier(updatedAbsence.isJustifier());
            absenceToUpdate.setRais_abs(updatedAbsence.getRais_abs());
            return absenceRepository.save(absenceToUpdate);
        } else {
            return null;
        }
    }

    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }
}
