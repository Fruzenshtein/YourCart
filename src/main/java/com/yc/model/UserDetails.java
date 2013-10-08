package com.yc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign",
	parameters=@Parameter(name="property", value="user"))
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String sex;
	
	private Date birthday;
	
	private String avatar;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	public UserDetails(User user, String firstName, String lastName, String sex, 
			Date birthday, String avatar) {
		this.id = user.getId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.birthday = birthday;
		this.avatar = avatar;
	}

	public UserDetails() {
	};
	
	/**
	 * Method updates current {@link UserDetails} object.
	 * @param ud - {@link UserDetails} object
	 * @return current {@link UserDetails}
	 */
	public UserDetails updateUserDetails(UserDetails ud) {
		this.firstName = ud.getFirstName();
		this.lastName = ud.getLastName();
		this.sex = ud.getSex();
		this.birthday = ud.getBirthday();
		this.avatar = ud.getAvatar();
		return this;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
