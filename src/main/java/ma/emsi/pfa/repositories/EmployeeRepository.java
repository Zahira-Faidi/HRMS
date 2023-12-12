package ma.emsi.pfa.repositories;

import ma.emsi.pfa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
