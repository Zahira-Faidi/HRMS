package ma.emsi.pfa.controllers;

import ma.emsi.pfa.entities.Absence;
import ma.emsi.pfa.services.AbsenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/absences")
public class AbsenceController {
    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping
    public List<Absence> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Long id) {
        Optional<Absence> absence = absenceService.getAbsenceById(id);
        return absence.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Absence> createAbsence(@RequestBody Absence absence) {
        Absence createdAbsence = absenceService.createAbsence(absence);
        return new ResponseEntity<>(createdAbsence, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable Long id, @RequestBody Absence updatedAbsence) {
        Absence updated = absenceService.updateAbsence(id, updatedAbsence);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
