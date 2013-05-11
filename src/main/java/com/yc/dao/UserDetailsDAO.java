package com.yc.dao;

import com.yc.model.UserDetails;

public interface UserDetailsDAO {
	
	public UserDetails getUserDetails(int userId);
	public void updateUserDetails(UserDetails userDetails);

}
