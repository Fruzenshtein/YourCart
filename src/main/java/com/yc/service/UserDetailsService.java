package com.yc.service;

import com.yc.model.UserDetails;

public interface UserDetailsService {
	
	public UserDetails getUserDetails(int userId);
	public void updateUserDetails(UserDetails userDetails);

}
