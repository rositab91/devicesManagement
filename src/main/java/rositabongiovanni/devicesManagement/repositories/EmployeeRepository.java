package rositabongiovanni.devicesManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rositabongiovanni.devicesManagement.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
