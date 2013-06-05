package com.yc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.yc.model.User;
import com.yc.service.UserService;

@Controller
@SessionAttributes({"userLogin", "userId"})
public class SecurityController {
	
	@Autowired
	private UserService userService;

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
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = userService.get(userLogin);
		
		mav.addObject("userLogin", userLogin);
		mav.addObject("userId", user.getId());
		return mav;
	}
	
}
