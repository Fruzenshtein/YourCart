package com.yc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userLogin")
public class SecurityController {

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
	
	@RequestMapping(value="/user/account")
	public ModelAndView welcomePage() {
		ModelAndView mav = new ModelAndView("user-account/welcome");
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		mav.addObject("userLogin", userLogin);
		return mav;
	}
	
}
