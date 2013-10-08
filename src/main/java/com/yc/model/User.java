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
	@Size(max=30)
	@Pattern(regexp="^[0-9a-zA-Z-_]+$")
	private String login;
	
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
	@JoinTable(name="shop_moders",
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="shop_id", referencedColumnName="id")}
	)
	private Set<Shop> moderShops;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="shop_owners",
		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="shop_id", referencedColumnName="id")}
	)
	private Set<Shop> userShops;
	
	public User() {};
	
	public User(String login, String email, String password) {
		this.login = login;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Method applies to {@link User} object. It updates login, 
	 * email, password and {@link UserDetails} fields
	 * @param user - {@link User} object contains new values
	 */
	public void update(User user) {
		this.setEmail(user.getEmail());
		this.setLogin(user.getLogin());
		this.setPassword(user.getPassword());
		this.setUserDetails(user.getUserDetails());
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
	public Set<Shop> getModerShops() {
		return moderShops;
	}
	public void setModerShops(Set<Shop> moderShops) {
		this.moderShops = moderShops;
	}
	public Set<Shop> getUserShops() {
		return userShops;
	}
	public void setUserShops(Set<Shop> userShops) {
		this.userShops = userShops;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
