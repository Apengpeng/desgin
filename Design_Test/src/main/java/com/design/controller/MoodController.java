package com.design.controller;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.design.service.api.IMoodService;
import com.design.service.model.MoodVO;
import com.design.util.TimeUtil;

@Controller
@RequestMapping(value = "/page")
public class MoodController {

	/**
	 * 获取当然情绪指数信息
	 * 
	 * @return
	 */
	@Resource
	private IMoodService moodService;

	@RequestMapping(value = {"/mood.do" })
	public ModelAndView Init(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		MoodVO moodVO = new MoodVO();
		moodVO = moodService.ShowDayMoodValue(TimeUtil
				.getDayBefore(null));
		System.out.println(moodVO.toString());
		ModelAndView model = new ModelAndView("mood");
		model.addObject("daymood", moodVO);
		
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");

		try {
			if (endtime == null || Date.valueOf(endtime) == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			endtime = TimeUtil.getDayBefore(null).toString();
		}
		
		try {
			if (begintime == null || Date.valueOf(begintime) == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			begintime = TimeUtil.getDayBefore100Day(null).toString();
		}
		
		Date begin = Date.valueOf(begintime);
		Date end = Date.valueOf(endtime);
		if (begin.after(end)) {
			String temp = null;
			temp = begintime;
			begintime = endtime;
			endtime = temp;
		}
		System.out.println("begintime:" + begintime + "endtime:" + endtime);
		List<MoodVO> list = moodService.ShowListMoodValue(begin, end);
		String mood = "";
		String date = "";
		for (int i = 0; i < list.size() - 1; i++) {
			mood = mood + list.get(i).getMoodValue() + ",";
			date = date + list.get(i).getDate().toString() + ",";
		}
		if (list.size() > 0) {
			mood = mood + list.get(list.size() - 1).getMoodValue();
			date = date + list.get(list.size() - 1).getDate().toString();
		}
		model.addObject("mood", mood);
		model.addObject("date", date);
		model.addObject("begintime", begintime);
		model.addObject("endtime", endtime);
		System.out.println(mood);
		System.out.println(date);

		return model;
	}
}
