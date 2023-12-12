package ma.emsi.pfa.controllers;

import ma.emsi.pfa.entities.Conge;
import ma.emsi.pfa.services.CongeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conges")
public class CongeController {
    private final CongeService congeService;

    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }

    @GetMapping
    public List<Conge> getAllConges() {
        return congeService.getAllConges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conge> getCongeById(@PathVariable Long id) {
        Optional<Conge> conge = congeService.getCongeById(id);
        return conge.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Conge> createConge(@RequestBody Conge conge) {
        Conge createdConge = congeService.createConge(conge);
        return new ResponseEntity<>(createdConge, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conge> updateConge(@PathVariable Long id, @RequestBody Conge updatedConge) {
        Conge updated = congeService.updateConge(id, updatedConge);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConge(@PathVariable Long id) {
        congeService.deleteConge(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
