package com.yc.service;

import com.yc.exception.UserDetailsNotFoundException;
import com.yc.model.UserDetails;

public interface UserDetailsService {
	
	public UserDetails get(int id);
	public UserDetails save(UserDetails userDetails);
	public UserDetails update(UserDetails userDetails) throws UserDetailsNotFoundException;

}
