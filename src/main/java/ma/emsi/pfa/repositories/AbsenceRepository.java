package ma.emsi.pfa.repositories;

import ma.emsi.pfa.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
