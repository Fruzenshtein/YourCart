package com.yc.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.dao.RoleDAO;
import com.yc.dao.UserDAO;
import com.yc.helper.PasswordEncoder;
import com.yc.model.Role;
import com.yc.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User getUser(String email) {
		return userDAO.getUser(email);
	}

	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	public void addUser(User user) {
		Role role = roleDAO.getRole(2);
		user.setRole(role);
		
		String md5 = passwordEncoder.getHash(user.getPassword());
		user.setPassword(md5);
		
		userDAO.addUser(user);
	}

	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	public void upadateUser(User user) {
		userDAO.upadateUser(user);
	}

}
