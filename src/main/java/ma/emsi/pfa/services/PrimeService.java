package ma.emsi.pfa.services;

import ma.emsi.pfa.entities.Prime;
import ma.emsi.pfa.repositories.PrimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrimeService {
    private final PrimeRepository primeRepository;

    public PrimeService(PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }

    public List<Prime> getAllPrimes() {
        return primeRepository.findAll();
    }

    public Optional<Prime> getPrimeById(Long id) {
        return primeRepository.findById(id);
    }

    public Prime createPrime(Prime prime) {
        return primeRepository.save(prime);
    }

    public Prime updatePrime(Long id, Prime updatedPrime) {
        Optional<Prime> existingPrime = primeRepository.findById(id);
        if (existingPrime.isPresent()) {
            Prime primeToUpdate = existingPrime.get();
            primeToUpdate.setMotif(updatedPrime.getMotif());
            primeToUpdate.setMontant(updatedPrime.getMontant());
            primeToUpdate.setDate(updatedPrime.getDate());
            return primeRepository.save(primeToUpdate);
        } else {
            return null;
        }
    }

    public void deletePrime(Long id) {
        primeRepository.deleteById(id);
    }
}
