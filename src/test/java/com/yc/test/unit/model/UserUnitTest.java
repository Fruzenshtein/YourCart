package com.yc.test.unit.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yc.model.UserDetails;

public class UserUnitTest {
	
	public UserDetails userDetails = null;

	@Before
	public void setUp() throws Exception {
		userDetails = new UserDetails(null, "Bob", "Sap", "M", new Date(0), "some_url");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
