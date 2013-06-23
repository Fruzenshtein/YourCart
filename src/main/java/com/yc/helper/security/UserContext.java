package com.yc.helper.security;

import com.yc.model.User;

public interface UserContext {
	
	public User getCurrentUser();
	public void setCurrentUser(User user);

}
