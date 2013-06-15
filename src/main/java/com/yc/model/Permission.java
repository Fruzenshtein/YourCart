package com.yc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="permissions")
public class Permission {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="role_permissions",
			joinColumns = {@JoinColumn(name="permission_id", referencedColumnName="id")},
			inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
	)
	private Set<Role> roles;
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
