package com.design.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class AboutController {
	
	@RequestMapping(value={"/about.do"})
	public ModelAndView Init(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("about");
		return model;
	}
}
