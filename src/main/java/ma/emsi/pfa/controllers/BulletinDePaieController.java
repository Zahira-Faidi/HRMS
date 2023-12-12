package ma.emsi.pfa.controllers;

import ma.emsi.pfa.entities.BulletinDePaie;
import ma.emsi.pfa.services.BulletinDePaieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bulletins-de-paie")
public class BulletinDePaieController {
    private final BulletinDePaieService bulletinDePaieService;

    public BulletinDePaieController(BulletinDePaieService bulletinDePaieService) {
        this.bulletinDePaieService = bulletinDePaieService;
    }

    @GetMapping
    public List<BulletinDePaie> getAllBulletinsDePaie() {
        return bulletinDePaieService.getAllBulletinsDePaie();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BulletinDePaie> getBulletinDePaieById(@PathVariable Long id) {
        Optional<BulletinDePaie> bulletinDePaie = bulletinDePaieService.getBulletinDePaieById(id);
        return bulletinDePaie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BulletinDePaie> createBulletinDePaie(@RequestBody BulletinDePaie bulletinDePaie) {
        BulletinDePaie createdBulletinDePaie = bulletinDePaieService.createBulletinDePaie(bulletinDePaie);
        return new ResponseEntity<>(createdBulletinDePaie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BulletinDePaie> updateBulletinDePaie(@PathVariable Long id, @RequestBody BulletinDePaie updatedBulletinDePaie) {
        BulletinDePaie updated = bulletinDePaieService.updateBulletinDePaie(id, updatedBulletinDePaie);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBulletinDePaie(@PathVariable Long id) {
        bulletinDePaieService.deleteBulletinDePaie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
