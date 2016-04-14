package com.design.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class InterfaceController {
	
	@RequestMapping(value={"/interface.do"})
	public ModelAndView Init(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request.getPathInfo());
		ModelAndView model = new ModelAndView("interface");
		return model;
	}
}
