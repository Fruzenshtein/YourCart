package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yc.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User u where u.email = :email")
	public User findByEmail(@Param(value = "email") String email);
	
}
