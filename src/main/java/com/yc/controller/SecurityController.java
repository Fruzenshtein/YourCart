package com.yc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yc.helper.security.SecurityUserContext;
import com.yc.service.UserService;

@Controller
public class SecurityController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityUserContext securityUserContext;

	@RequestMapping(value="/user-login")
	public ModelAndView loginPage() {
		return new ModelAndView("security/login-form");
	}
	
	@RequestMapping(value="/error-login")
	public ModelAndView errorLoginPage() {
		ModelAndView modelAndView = new ModelAndView("security/login-form");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/user/login")
	public ModelAndView welcomePage() {
		ModelAndView mav = new ModelAndView("user-account/welcome");
		return mav;
	}
	
}
