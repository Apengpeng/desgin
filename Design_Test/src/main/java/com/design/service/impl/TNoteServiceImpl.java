package com.design.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.design.dao.api.IMoodDao;
import com.design.dao.api.ITitleDao;
import com.design.dao.model.Mood;
import com.design.service.api.ITNoteService;
import com.design.service.model.TNoteVO;

@Service("tNoteService")
public class TNoteServiceImpl implements ITNoteService {

	@Resource
	private IMoodDao moodDao;

	@Resource
	private ITitleDao titleDao;

	@Override
	public TNoteVO ShowDayNote(Date date) {

		TNoteVO tNoteVO = new TNoteVO();

		Mood mood = moodDao.getDayMoodValueByDay(date);
		tNoteVO.setMoodvalue(mood.getValue());

		TNoteVO temp = new TNoteVO();
		temp = titleDao.SumNoteByDay(date);
		if(temp==null){
			return null;
		}
		System.out.println(temp.toString());
		tNoteVO.setDate(temp.getDate());
		tNoteVO.setReading(temp.getReading());
		tNoteVO.setComments(temp.getComments());
		tNoteVO.setCreate(temp.getCreate());

		return tNoteVO;
	}

	@Override
	public List<TNoteVO> ShowListDayNote(Date begin, Date end) {
		return titleDao.ListSumNote(begin, end);
	}
}
