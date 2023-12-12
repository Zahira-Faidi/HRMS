package ma.emsi.pfa.repositories;

import ma.emsi.pfa.entities.Prime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimeRepository extends JpaRepository<Prime, Long> {
}
