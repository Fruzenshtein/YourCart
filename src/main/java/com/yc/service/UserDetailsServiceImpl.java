package com.yc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.UserDetailsDAO;
import com.yc.model.UserDetails;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	public UserDetails getUserDetails(int userId) {
		return userDetailsDAO.getUserDetails(userId);
	}

	public void updateUserDetails(UserDetails userDetails) {
		userDetailsDAO.updateUserDetails(userDetails);
	}

}
