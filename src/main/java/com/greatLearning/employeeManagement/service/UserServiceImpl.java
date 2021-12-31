package com.greatLearning.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.User;
import com.greatLearning.employeeManagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User user) {

		userRepository.save(user);

	}

}
