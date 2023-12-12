package ma.emsi.pfa.controllers;

import ma.emsi.pfa.entities.Prime;
import ma.emsi.pfa.services.PrimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/primes")
public class PrimeController {
    private final PrimeService primeService;

    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping
    public List<Prime> getAllPrimes() {
        return primeService.getAllPrimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prime> getPrimeById(@PathVariable Long id) {
        Optional<Prime> prime = primeService.getPrimeById(id);
        return prime.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Prime> createPrime(@RequestBody Prime prime) {
        Prime createdPrime = primeService.createPrime(prime);
        return new ResponseEntity<>(createdPrime, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prime> updatePrime(@PathVariable Long id, @RequestBody Prime updatedPrime) {
        Prime updated = primeService.updatePrime(id, updatedPrime);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrime(@PathVariable Long id) {
        primeService.deletePrime(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
