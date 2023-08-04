package rositabongiovanni.devicesManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rositabongiovanni.devicesManagement.entities.Employee;
import rositabongiovanni.devicesManagement.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepository employeeRepo;

	public void save(Employee e) {
		employeeRepo.save(e);
	}

	public void saveAndFlush(Employee e) {
		employeeRepo.saveAndFlush(e);
	}

	public void update(Employee e) {
		employeeRepo.save(e);
	}

	public void delete(Employee e) {
		employeeRepo.delete(e);
	}

	public Optional<Employee> findById(long id) {
		return employeeRepo.findById(id);
	}

	public Employee post(String un, String fn, String email) {
		Employee e = new Employee(un, fn, email);
		employeeRepo.saveAndFlush(e);
		return e;
	}

}