package com.yc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yc.exception.UserDetailsNotFoundException;
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
	
	@RequestMapping(value="/user/account", method=RequestMethod.GET)
	public ModelAndView welcomePage() {
		return new ModelAndView("user-account/welcome");
	}
	
	@RequestMapping(value="/user/details", method=RequestMethod.GET)
	public ModelAndView userDetailsPage() {
		ModelAndView mav = new ModelAndView("user-account/details");
		
		Integer userId = (Integer) RequestContextHolder.currentRequestAttributes()
				.getAttribute("userId", RequestAttributes.SCOPE_SESSION);
		
		UserDetails ud = userDetailsService.get(userId);
		
		if (ud != null)
			mav.addObject("userDetails", ud);
		else
			mav.addObject("userDetails", new UserDetails());
		
		return mav;
	}
	
	@RequestMapping(value="/user/details", method=RequestMethod.PUT)
	public ModelAndView saveUserDetails(@ModelAttribute @Valid UserDetails userDetails,
			BindingResult result,
			final RedirectAttributes redirectAttributes) throws UserDetailsNotFoundException {
		ModelAndView mav = new ModelAndView("redirect:details.html");
		
		if (result.hasErrors())
			return new ModelAndView("user-account/details");
		
		String message = "Информация о пользователе успешно изменена.";
		
		Integer userId = (Integer) RequestContextHolder.currentRequestAttributes()
				.getAttribute("userId", RequestAttributes.SCOPE_SESSION);
		
		userDetails.setId(userId);
		
		userDetailsService.update(userDetails);
		
		redirectAttributes.addFlashAttribute("success_msg", message);
		
		return mav;
	}

}
