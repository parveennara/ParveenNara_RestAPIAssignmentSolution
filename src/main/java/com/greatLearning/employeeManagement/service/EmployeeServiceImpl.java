package com.greatLearning.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {

		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Optional<Employee> findById(int id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}

	@Override
	public void save(Employee employee) {

		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {

		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {

		List<Employee> employees = employeeRepository.findByFirstNameIgnoreCase(firstName);
		return employees;
	}

	@Override
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction direction) {

		List<Employee> employees = employeeRepository.findAll(Sort.by(direction, "firstName"));
		return employees;
	}

	@Override
	public String updateEmployee(Employee employee, int id) {

		employeeRepository.saveAndFlush(employee);
		return "Employee updated successfully.";
	}

}
