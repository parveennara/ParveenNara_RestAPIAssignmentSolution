package com.greatLearning.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void save(Role role) {
		
		roleRepository.save(role);
		
	}

}
