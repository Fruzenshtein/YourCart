package com.yc.dao;

import com.yc.model.User;

public interface UserDAO {

	public User getUser(String email);
	public User getUser(int id);
	public void addUser(User user);
	public void deleteUser(int id);
	public void upadateUser(User user);
	
}
