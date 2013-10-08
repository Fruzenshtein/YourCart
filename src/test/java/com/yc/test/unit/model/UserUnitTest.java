package com.yc.test.unit.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yc.model.User;
import com.yc.model.UserDetails;

public class UserUnitTest {
	
	private final static String LOGIN = "user1";
	private final static String EMAIL = "email@gmail.com";
	private final static String PASSWORD = "111111";
	
	private final static String FIRST_NAME = "Bob";
	private final static String LAST_NAME = "Sap";
	private final static String SEX = "M";
	private final static Date BIRTHDAY = new Date(0);
	private final static String AVATAR = "www.img-host.com/avatar.jpg";
	
	private UserDetails userDetails = null;
	private User user = null;

	@Before
	public void setUp() throws Exception {
		user = new User(LOGIN, EMAIL, PASSWORD);
		userDetails = new UserDetails(0, FIRST_NAME, LAST_NAME, SEX, BIRTHDAY, AVATAR);
		
		user.setUserDetails(userDetails);
		userDetails.setUser(user);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void checkUserConstructor() {
		assertEquals(LOGIN, user.getLogin());
		assertEquals(EMAIL, user.getEmail());
		assertEquals(PASSWORD, user.getPassword());
	}
	
	@Test
	public void checkUserAndUserDetailsCorrespondingFields() {
		assertEquals(LOGIN, userDetails.getUser().getLogin());
		assertEquals(EMAIL, userDetails.getUser().getEmail());
		assertEquals(PASSWORD, userDetails.getUser().getPassword());
		
		assertEquals(FIRST_NAME, user.getUserDetails().getFirstName());
		assertEquals(LAST_NAME, user.getUserDetails().getLastName());
		assertEquals(SEX, user.getUserDetails().getSex());
		assertEquals(BIRTHDAY, user.getUserDetails().getBirthday());
		assertEquals(AVATAR, user.getUserDetails().getAvatar());
	}

}
