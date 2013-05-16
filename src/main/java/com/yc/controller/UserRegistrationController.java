package com.yc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yc.model.User;
import com.yc.service.UserService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registrationPage() {
		ModelAndView modelAndView = new ModelAndView("user-registration/registration-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute @Valid User user, 
			BindingResult result,
			final RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:registration.html");
		
		if (result.hasErrors())
			return modelAndView;
		
		User tempUser = userService.getUser(user.getEmail());
		Map<String, String> messages = new HashMap<String, String>();
		
		if (tempUser == null) {
						
			userService.addUser(user);
			
			messages.put("success", "message.user.success.register");
		} else {
			messages.put("error", "message.user.invalid.register");
		}
		
		redirectAttributes.addFlashAttribute("messages", messages);
		
		return modelAndView;
		
	}

}
