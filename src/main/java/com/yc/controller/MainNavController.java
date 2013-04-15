package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainNavController {
	
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView mainPageIndex() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/about-us")
	public ModelAndView aboutUs() {
		return new ModelAndView("about-us");
	}

}
