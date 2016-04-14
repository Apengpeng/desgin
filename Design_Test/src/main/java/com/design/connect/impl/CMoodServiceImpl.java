package com.design.connect.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.service.api.IMoodService;
import com.design.service.model.MoodVO;

@RequestMapping("interface/mood")
@Controller
public class CMoodServiceImpl {

	@Resource
	private IMoodService moodService;

	@RequestMapping(value = "/mood.do", method = RequestMethod.GET)
	@ResponseBody
	public String ShowDayMoodValue(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("connect daymood");
		if (request.getParameter("date") == ""
				|| request.getParameter("date") == null) {
			return "Error";
		}

		try {
			Date.valueOf(request.getParameter("date"));
		} catch (Exception e) {
			return "Error";
		}

		MoodVO moodvo = moodService.ShowDayMoodValue(Date.valueOf(request
				.getParameter("date")));

		return moodvo.toString();
	}

	@ResponseBody
	@RequestMapping(value="/listMoodValue.do",method=RequestMethod.GET)
	public String ShowListMoodValue(HttpServletRequest request,
			HttpServletResponse response) {
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		if(begintime=="" || endtime==""){
			return "Error";
		}
		try{
			Date.valueOf(begintime);
			Date.valueOf(endtime);
		}catch(Exception e){
			return "Error";
		}
		
		Date begin = Date.valueOf(begintime);
		Date end = Date.valueOf(endtime);
		if (begin.after(end)) {
			String temp = null;
			temp = begintime;
			begintime = endtime;
			endtime = temp;
		}
		
		List<MoodVO> list = moodService.ShowListMoodValue(begin, end);
		return list.toString();
	}

}
