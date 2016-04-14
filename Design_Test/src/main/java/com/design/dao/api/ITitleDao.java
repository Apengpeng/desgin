package com.design.dao.api;


import java.sql.Date;
import java.util.List;

import com.design.dao.model.Title;
import com.design.service.model.AuthorVO;
import com.design.service.model.NoteVO;
import com.design.service.model.TNoteVO;


public interface ITitleDao {
	
	
	public List<Title> SearchTop5ByReading(Date date);
	
	public List<Title> SearchTop5ByComments(Date date);
	
	public List<AuthorVO> SearchTop5ByAuthor(Date date);
	
	public List<NoteVO> SearchByDay(Date date);
	
	public TNoteVO SumNoteByDay(Date date);
	
	public List<TNoteVO> ListSumNote(Date begin,Date end);
	public int CountNoteByDate(Date time) ;
}
