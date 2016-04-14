package com.design.connect.impl;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.service.api.INoteService;
import com.design.util.TimeUtil;

@RequestMapping("/interface/note")
@Controller
public class CNoteServiceImpl {

	@Resource
	private INoteService noteService;

	@RequestMapping(value = "/reading.do", method = RequestMethod.GET)
	@ResponseBody
	public String ShowReading(HttpServletRequest request,
			HttpServletResponse response) {
		java.sql.Date date = TimeUtil.JudgeStringTime(request
				.getParameter("date"));
		if (date == null) {
			return null;
		}
		return noteService.ShowReading(date).toString();
	}

	@RequestMapping(value = "/comments.do", method = RequestMethod.GET)
	@ResponseBody
	public String ShowComments(HttpServletRequest request,
			HttpServletResponse response) {
		java.sql.Date date = TimeUtil.JudgeStringTime(request
				.getParameter("date"));
		if (date == null) {
			return null;
		}

		return noteService.ShowComments(date).toString();
	}

	@RequestMapping(value = "/author.do", method = RequestMethod.GET)
	@ResponseBody
	public String ShowAuthor(HttpServletRequest request,
			HttpServletResponse response) {
		java.sql.Date date = TimeUtil.JudgeStringTime(request
				.getParameter("date"));
		if (date == null) {
			return null;
		}
		return noteService.ShowAuthor(date).toString();
	}
}
