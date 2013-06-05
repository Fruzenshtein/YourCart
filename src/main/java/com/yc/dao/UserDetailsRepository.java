package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yc.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

}
