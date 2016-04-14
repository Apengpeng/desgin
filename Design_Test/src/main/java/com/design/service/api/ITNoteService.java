package com.design.service.api;

import java.sql.Date;
import java.util.List;

import com.design.service.model.TNoteVO;

public interface ITNoteService {
	public TNoteVO ShowDayNote(Date date);

	public List<TNoteVO> ShowListDayNote(Date begin,Date end);
}
