package com.yc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.yc.model.User;
import com.yc.model.UserDetails;
import com.yc.service.UserDetailsService;
import com.yc.service.UserService;

@Controller
public class UserAccountController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value="/user/account")
	public ModelAndView welcomePage() {
		return new ModelAndView("user-account/welcome");
	}
	
	@RequestMapping(value="/user/details", method=RequestMethod.GET)
	public ModelAndView userDetailsPage() {
		ModelAndView mav = new ModelAndView("user-account/details");
		
		Integer userId = (Integer) RequestContextHolder.currentRequestAttributes()
				.getAttribute("userId", RequestAttributes.SCOPE_SESSION);
		
		UserDetails ud = userDetailsService.getUserDetails(userId);
		
		if (ud != null)
			mav.addObject("userDetails", ud);
		else
			mav.addObject("userDetails", new UserDetails());
		
		return mav;
	}
	
	@RequestMapping(value="/user/details", method=RequestMethod.POST)
	public ModelAndView saveUserDetails(@ModelAttribute UserDetails userDetails) {
		ModelAndView mav = new ModelAndView("user-account/details");
		
		Integer userId = (Integer) RequestContextHolder.currentRequestAttributes()
				.getAttribute("userId", RequestAttributes.SCOPE_SESSION);
		
		User user = userService.getUser(userId);
		UserDetails ud = user.getUserDetails();
		ud = ud.updateUserDetails(userDetails);
		
		ud.setUser(user);
		user.setUserDetails(ud);
		
		userDetailsService.updateUserDetails(ud);
		
		return mav;
	}

}
