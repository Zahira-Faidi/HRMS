package ma.emsi.pfa.services;

import ma.emsi.pfa.entities.Employee;
import ma.emsi.pfa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employeeToUpdate = existingEmployee.get();
            employeeToUpdate.setCin(updatedEmployee.getCin());
            employeeToUpdate.setNom(updatedEmployee.getNom());
            employeeToUpdate.setPrenom(updatedEmployee.getSexe());
            employeeToUpdate.setNb_enfant(updatedEmployee.getNb_enfant());
            employeeToUpdate.setType_contat(updatedEmployee.getType_contat());
            employeeToUpdate.setAdresse(updatedEmployee.getAdresse());
            employeeToUpdate.setTel(updatedEmployee.getTel());
            employeeToUpdate.setEmail(updatedEmployee.getEmail());
            employeeToUpdate.setDate_emboche(updatedEmployee.getDate_emboche());
            employeeToUpdate.setNb_jourConge(updatedEmployee.getNb_jourConge());
            employeeToUpdate.setLogin(updatedEmployee.getLogin());
            employeeToUpdate.setPassword(updatedEmployee.getPassword());
            employeeToUpdate.setRole(updatedEmployee.getRole());
            return employeeRepository.save(employeeToUpdate);
        } else {
            return null;
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
