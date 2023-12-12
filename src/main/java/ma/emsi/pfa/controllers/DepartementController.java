package ma.emsi.pfa.controllers;

import ma.emsi.pfa.entities.Departement;
import ma.emsi.pfa.services.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departements")
public class DepartementController {
    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Long id) {
        Optional<Departement> departement = departementService.getDepartementById(id);
        return departement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement createdDepartement = departementService.createDepartement(departement);
        return new ResponseEntity<>(createdDepartement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id, @RequestBody Departement updatedDepartement) {
        Departement updated = departementService.updateDepartement(id, updatedDepartement);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
