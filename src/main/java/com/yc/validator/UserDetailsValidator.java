package com.yc.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yc.model.UserDetails;

public class UserDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDetails.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		UserDetails ud = (UserDetails) target;
		Date birthday = ud.getBirthday();
		
		if (!birthday.getClass().isAssignableFrom(Date.class))
			errors.rejectValue("birthday", "date.invalid.format");
	}

}
