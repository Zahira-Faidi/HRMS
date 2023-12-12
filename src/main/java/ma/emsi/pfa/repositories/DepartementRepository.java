package ma.emsi.pfa.repositories;

import ma.emsi.pfa.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
}
