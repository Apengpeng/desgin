package com.design.controller;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.design.service.api.ITNoteService;
import com.design.service.model.TNoteVO;
import com.design.util.TimeUtil;

@Controller
@RequestMapping("/page")
public class DayMoodController {

	public static int DAYNOTE_PAGE = 0;
	public static int DAYNOTE_PAGE_SIZE = 10;

	@Resource
	public ITNoteService tNoteService;

	/**
	 * 获取当天帖子统计的信息
	 * 
	 * @return
	 */

	@RequestMapping(value = { "/daymood.do" })
	public ModelAndView Init(HttpServletRequest request,
			HttpServletResponse response) {

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

		ModelAndView model = new ModelAndView("daymood");
		TNoteVO tNoteVO = tNoteService.ShowDayNote(TimeUtil.getDayBefore(null));
		if (tNoteVO == null) {
			tNoteVO = new TNoteVO();
			System.out.println("tNoteVO:" + tNoteVO.toString());
		}
		model.addObject("tNoteVO", tNoteVO);
		
		Date begin = Date.valueOf(begintime);
		Date end = Date.valueOf(endtime);
		if (begin.after(end)) {
			String temp = null;
			temp = begintime;
			begintime = endtime;
			endtime = temp;
		}
		System.out.println("begintime:" + begintime + "endtime:" + endtime);
		List<TNoteVO> list = tNoteService.ShowListDayNote(
				Date.valueOf(begintime), Date.valueOf(endtime));
		String reading = "";
		String comments = "";
		String create = "";
		String date = "";
		for (int i = 0; i < list.size() - 1; i++) {
			reading = reading + list.get(i).getReading() + ",";
			comments = comments + list.get(i).getComments() + ",";
			create = create + list.get(i).getCreate() + ",";
			date = date + list.get(i).getDate().toString() + ",";
		}
		if (list.size() > 0) {
			reading = reading + list.get(list.size() - 1).getReading();
			comments = comments + list.get(list.size() - 1).getComments();
			create = create + list.get(list.size() - 1).getCreate();
			date = date + list.get(list.size() - 1).getDate().toString();
		}
		model.addObject("reading", reading);
		model.addObject("comments", comments);
		model.addObject("create", create);
		model.addObject("date", date);
		model.addObject("begintime", begintime);
		model.addObject("endtime", endtime);
		System.out.println(date);
		System.out.println(reading);
		System.out.println(comments);
		System.out.println(create);
		return model;
	}

}
