package rositabongiovanni.devicesManagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rositabongiovanni.devicesManagement.entities.Employee;
import rositabongiovanni.devicesManagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@GetMapping("/{id}")
	public Employee get(@PathVariable long id) {
		return employeeService.findById(id).get();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable long id, @RequestBody Optional<Employee> employeeDto) throws Exception {
		Optional<Employee> optEmployee = employeeService.findById(id);
		if (optEmployee.isPresent()) {
			Employee e = optEmployee.get();
			if (!employeeDto.get().getEmail().equals(null)) {
				e.setEmail(employeeDto.get().getEmail());
			}
			if (!employeeDto.get().getFullname().equals(null)) {
				e.setFullname((employeeDto.get().getFullname()));
			}
			if (!employeeDto.get().getUsername().equals(null)) {
				e.setUsername(employeeDto.get().getUsername());
			}
			employeeService.update(e);
			System.out.println("updated employee: " + e.toString());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public String post(@RequestBody Employee e) {
		e = employeeService.post(e.getUsername(), e.getFullname(), e.getEmail());
		return "added employee: " + e.toString();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@RequestBody Employee e, @PathVariable long id) {
		Optional<Employee> optEmployee = employeeService.findById(id);
		if (optEmployee.isPresent()) {
			System.out.println("deleted employee: " + e.toString());
			employeeService.delete(e);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

