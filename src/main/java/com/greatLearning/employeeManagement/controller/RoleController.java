package com.greatLearning.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/add")
	public String createRole(@RequestBody Role role) {

		roleService.save(role);
		return "Role created successfully";
	}
}
