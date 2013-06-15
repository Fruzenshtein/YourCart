package com.yc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.UserRepository;
import com.yc.exception.UserNotFoundException;
import com.yc.helper.PasswordEncoder;
import com.yc.model.Role;
import com.yc.model.User;
import com.yc.model.UserDetails;

@Service
@Transactional(rollbackFor = UserNotFoundException.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User get(String email) {
		return userRepository.findByEmail(email);
	}

	public User get(int id) {
		return userRepository.findOne(id);
	}

	@PreAuthorize(value="isAnonymous()")
	public User save(User user) {
		Role role = roleService.findById(2);
		UserDetails userDetails = new UserDetails();
		userDetails.setBirthday(new Date(0));
		
		user.setRole(role);
		user.setUserDetails(userDetails);
		userDetails.setUser(user);
		
		String md5 = passwordEncoder.getHash(user.getPassword());
		user.setPassword(md5);
		
		userRepository.save(user);
		
		return user;
	}

	public User delete(int id) throws UserNotFoundException {
		User userToDelete = get(id);
		if (userToDelete == null)
			throw new UserNotFoundException();
		userRepository.delete(userToDelete);
		return userToDelete;
	}

	@PreAuthorize(value="isAuthenticated()")
	public User update(User user) throws UserNotFoundException {
		User userToUpdate = get(user.getId());
		if (userToUpdate == null)
			throw new UserNotFoundException();
		
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setRole(user.getRole());
		userToUpdate.setUserDetails(user.getUserDetails());
		
		return userToUpdate;		
	}

}
