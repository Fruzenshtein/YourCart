package com.yc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.UserDetailsRepository;
import com.yc.exception.UserDetailsNotFoundException;
import com.yc.model.UserDetails;

@Service
@Transactional(rollbackFor=UserDetailsNotFoundException.class)
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public UserDetails get(int id) {
		return userDetailsRepository.findOne(id);
	}
	
	public UserDetails save(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}

	public UserDetails update(UserDetails userDetails) throws UserDetailsNotFoundException {
		UserDetails ud = get(userDetails.getId());
		if (ud == null)
			throw new UserDetailsNotFoundException();
		
		ud.updateUserDetails(userDetails);
		
		return ud;
	}

}
