package com.yc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yc.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public User getUser(String email) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from User u where u.email = :email");
		query.setParameter("email", email);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;		
	}

	public User getUser(int id) {
		User user = (User) openSession().get(User.class, id);
		return user;
	}

	public void addUser(User user) {
		openSession().save(user);
	}

	public void deleteUser(int id) {
		User user = getUser(id);
		if (user != null)
			openSession().delete(user);
	}

	public void upadateUser(User user) {
		if(getUser(user.getId()) != null)
			openSession().update(user);
	}

}
