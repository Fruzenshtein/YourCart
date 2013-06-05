package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yc.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
