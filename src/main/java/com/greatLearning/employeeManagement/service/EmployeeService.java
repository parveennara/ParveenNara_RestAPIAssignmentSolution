package com.greatLearning.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;
import com.greatLearning.employeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Optional<Employee> findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

	public List<Employee> searchByFirstName(String firstName);

	public List<Employee> getEmployeesCustomSortedByFirstName(Direction direction);

	public Employee updateEmployee(Employee employee, int id);

}
