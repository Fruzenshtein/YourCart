package com.yc.service;

import com.yc.exception.UserNotFoundException;
import com.yc.model.User;

public interface UserService {

	public User get(String email);
	public User get(int id);
	public User save(User user);
	public User delete(int id) throws UserNotFoundException;
	public User update(User user) throws UserNotFoundException;

}
