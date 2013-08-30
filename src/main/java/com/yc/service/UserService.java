package com.yc.service;

import org.springframework.security.access.prepost.PreAuthorize;

import com.yc.exception.UserNotFoundException;
import com.yc.model.User;

public interface UserService {

	public User get(String email);

	public User get(int id);

	@PreAuthorize("isAnonymous()")
	public User save(User user);

	public User delete(int id) throws UserNotFoundException;
	
	@PreAuthorize("#user.id == principal.id")
	public User update(User user) throws UserNotFoundException;

}
