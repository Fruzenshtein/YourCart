package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainNavController {
	
	@RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/about-us", method=RequestMethod.GET)
	public ModelAndView aboutUs() {
		return new ModelAndView("about-us");
	}

}
