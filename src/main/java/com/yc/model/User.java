package com.yc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	@Size(min=6, max=40)
	@Pattern(regexp="^[\\w\\.]+@[\\w]+\\.[a-z]{2,4}$")
	private String email;
	
	@NotEmpty
	@Size(max=32)
	private String password;
	
	@OneToOne
	@JoinTable(name="user_roles",
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
	)
	private Role role;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private UserDetails userDetails;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_shops",
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="shop_id", referencedColumnName="id")}
	)
	private Set<Shop> shops;
	
	public Set<Shop> getShops() {
		return shops;
	}
	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
