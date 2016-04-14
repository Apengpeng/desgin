package com.design.dao.api;


import java.sql.Date;
import java.util.List;

import com.design.dao.model.Mood;


public interface IMoodDao {

	
	public List<Mood> list(Date begintime,Date endtime);
	
	public Mood getDayMoodValueByDay(Date date);
	
	public List<Mood> getTwoDayMoodValue(Date date);
}
