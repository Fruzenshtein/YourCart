package com.yc.service;

import org.springframework.security.access.prepost.PreAuthorize;

import com.yc.exception.UserDetailsNotFoundException;
import com.yc.model.UserDetails;

public interface UserDetailsService {
	
	@PreAuthorize("isAuthenticated()")
	public UserDetails get(int id);
	
	public UserDetails save(UserDetails userDetails);
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or #userDetails.id == principal.id")
	public UserDetails update(UserDetails userDetails) throws UserDetailsNotFoundException;

}
