package com.design.controller;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.design.service.api.INoteService;
import com.design.service.model.AuthorVO;
import com.design.service.model.NoteVO;
import com.design.util.TimeUtil;

@Controller
@RequestMapping("/page")
public class NoteController {

	@SuppressWarnings("deprecation")
	public static Date NOTE_TIME = TimeUtil.getDayBefore(new Date(System
			.currentTimeMillis()).toLocaleString());;
	public static int NOTE_PAGE = 0;
	public static int TOTAL_PAGE = 0;
	public static int PAGE_SIZE = 10;
	/**
	 * 获取阅读量排名
	 * 
	 * @return
	 */
	@Resource
	private INoteService noteService;

	@SuppressWarnings("deprecation")
	@RequestMapping(value = { "/note.do" })
	public ModelAndView Init(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("note");
		List<NoteVO> reading = noteService.ShowReading(TimeUtil
				.getDayBefore(null));
		List<NoteVO> comments = noteService.ShowComments(TimeUtil
				.getDayBefore(null));
		List<AuthorVO> create = noteService.ShowAuthor(TimeUtil
				.getDayBefore(null));

		model.addObject("reading", reading);
		System.out.println(reading.get(0).toString());
		model.addObject("comments", comments);
		model.addObject("create", create);

		try {
			String time = request.getParameter("time");
			if (NoteController.NOTE_TIME != Date.valueOf(time)) {
				NoteController.NOTE_TIME = Date.valueOf(time);
				NoteController.NOTE_PAGE = 1;
				NoteController.TOTAL_PAGE = noteService.CountNoteByDate(Date
						.valueOf(time));
			}
		} catch (Exception e) {
			NoteController.NOTE_PAGE = 1;
			NoteController.NOTE_TIME = TimeUtil.getDayBefore(null);
		}

		try {
			int page = Integer.valueOf(request.getParameter("page"));
			if(page<=0){
				throw new Exception();
			}
			NoteController.NOTE_PAGE = page;
		} catch (Exception e) {
			NoteController.NOTE_PAGE = 1;
		}
		NoteController.TOTAL_PAGE = noteService.CountNoteByDate(NOTE_TIME);
		List<NoteVO> note = noteService.ShowListNoteByDay(NOTE_TIME);
		System.out.println(note.size()+":"+NOTE_TIME+":"+TOTAL_PAGE+":"+NOTE_PAGE);
		model.addObject("note", note);
		model.addObject("totle_page", NoteController.TOTAL_PAGE);
		model.addObject("now_page", NoteController.NOTE_PAGE);
		model.addObject("time", NoteController.NOTE_TIME);
		return model;
	}
}
