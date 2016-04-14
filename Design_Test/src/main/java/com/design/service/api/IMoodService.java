package com.design.service.api;

import java.sql.Date;
import java.util.List;

import com.design.service.model.MoodVO;

public interface IMoodService {

	public MoodVO ShowDayMoodValue(Date date);
	
	public List<MoodVO> ShowListMoodValue(Date begin,Date end);
}
