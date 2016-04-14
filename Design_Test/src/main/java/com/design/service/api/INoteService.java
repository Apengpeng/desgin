package com.design.service.api;

import java.sql.Date;
import java.util.List;

import com.design.service.model.AuthorVO;
import com.design.service.model.NoteVO;

public interface INoteService {

	public List<NoteVO> ShowReading(Date date);

	public List<NoteVO> ShowComments(Date date);

	public List<AuthorVO> ShowAuthor(Date date);

	public List<NoteVO> ShowListNoteByDay(Date date);
	
	public int CountNoteByDate(Date time);
}
