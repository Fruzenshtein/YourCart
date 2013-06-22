package com.yc.helper.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.yc.model.User;
import com.yc.service.UserService;

@Component
public class SecurityUserContext implements UserContext {
	
	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		
		if (auth == null)
			return null;
		
		return (User) auth.getPrincipal();
	}

	@Override
	public void setCurrentUser(User user) {
		// TODO Part for the immediately signing in after the registration
		//Spring Security 3.1 page 56
		
	}

}
