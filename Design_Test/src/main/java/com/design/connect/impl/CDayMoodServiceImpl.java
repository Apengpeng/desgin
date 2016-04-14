package com.design.connect.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.service.api.ITNoteService;
import com.design.util.TimeUtil;

@RequestMapping("/interface/daymood")
@Controller
public class CDayMoodServiceImpl {

	@Resource
	private ITNoteService tNoteService;

	@RequestMapping(value = "/daymood", method = RequestMethod.GET)
	@ResponseBody
	public String ShowDayNote(HttpServletRequest request,
			HttpServletResponse response) {
		java.sql.Date date = TimeUtil.JudgeStringTime(request
				.getParameter("date"));
		if (date == null) {
			return null;
		}
		return tNoteService.ShowDayNote(date).toString();
	}

	@RequestMapping(value = "/listdaymood", method = RequestMethod.GET)
	@ResponseBody
	public String ShowListDayNote(HttpServletRequest request,
			HttpServletResponse response) {
		java.sql.Date begintime = TimeUtil.JudgeStringTime(request
				.getParameter("begintime"));
		java.sql.Date endtime = TimeUtil.JudgeStringTime(request
				.getParameter("endtime"));
		if (begintime == null || endtime == null) {
			return null;
		}
		if (begintime.after(endtime)) {
			java.sql.Date temp = null;
			temp = begintime;
			begintime = endtime;
			endtime = temp;
		}

		return tNoteService.ShowListDayNote(begintime, endtime).toString();
	}
}
