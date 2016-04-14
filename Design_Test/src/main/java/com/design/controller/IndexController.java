package com.design.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value={""})
	public ModelAndView Init(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request.getPathInfo());
		ModelAndView model = new ModelAndView("index");
		return model;
	}
}
