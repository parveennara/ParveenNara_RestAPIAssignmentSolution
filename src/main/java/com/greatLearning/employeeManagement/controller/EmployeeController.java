package com.greatLearning.employeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list")
	public List<Employee> listEmployees() {

		return employeeService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {

		return employeeService.findById(id);

	}

	@GetMapping("/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable("firstName") String firstName) {

		return employeeService.searchByFirstName(firstName);

	}

	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee employee) {

		employeeService.save(employee);
		return "Employee added successfully";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {

		employeeService.deleteById(id);
		return "Deleted Employee id- " + id;
	}

	@GetMapping("/sort")
	public List<Employee> customSortEmployeeByName(Direction direction) {

		return employeeService.getEmployeesCustomSortedByFirstName(direction);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") int id) {
		
		return employeeService.updateEmployee(employee, id);
	}
}
