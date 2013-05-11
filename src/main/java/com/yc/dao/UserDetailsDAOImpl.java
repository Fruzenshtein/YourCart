package com.yc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yc.model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public UserDetails getUserDetails(int userId) {
		UserDetails ud = (UserDetails) openSession().get(UserDetails.class, userId);
		return ud;
	}

	public void updateUserDetails(UserDetails userDetails) {
		openSession().saveOrUpdate(userDetails);
	}

}
