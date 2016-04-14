package com.design.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.design.dao.api.ITitleDao;
import com.design.dao.model.Title;
import com.design.service.api.INoteService;
import com.design.service.model.AuthorVO;
import com.design.service.model.NoteVO;

@Service("noteService")
public class NoteServiceImpl implements INoteService {

	@Resource
	public ITitleDao titleDao;

	public List<NoteVO> ShowReading(Date date) {
		List<NoteVO> list = new ArrayList<NoteVO>();
		List<Title> titleList = null;
		titleList = titleDao.SearchTop5ByReading(date);
		NoteVO noteVO = null;
		for (Title title : titleList) {
			noteVO = new NoteVO();
			noteVO.setTitle(title.getTitle());
			noteVO.setReading(title.getReading());
			list.add(noteVO);
		}
		return list;
	}

	@Override
	public List<NoteVO> ShowComments(Date date) {
		List<NoteVO> list = new ArrayList<NoteVO>();
		List<Title> titleList = null;
		titleList = titleDao.SearchTop5ByComments(date);
		NoteVO noteVO = null;
		for (Title title : titleList) {
			noteVO = new NoteVO();
			noteVO.setTitle(title.getTitle());
			noteVO.setComments(title.getComment());
			list.add(noteVO);
		}
		return list;
	}

	@Override
	public List<AuthorVO> ShowAuthor(Date date) {
		return titleDao.SearchTop5ByAuthor(date);
	}

	@Override
	public List<NoteVO> ShowListNoteByDay(Date date) {

		return titleDao.SearchByDay(date);
	}

	public int CountNoteByDate(Date time) {
		return titleDao.CountNoteByDate(time);
	}

}
