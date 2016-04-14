package com.design.dao.api;

import java.sql.Date;
import java.util.List;

import com.design.dao.model.SHClose;


public interface ISHCloseDao {

	public List<SHClose> list(Date begintime, Date endtime);
	
	public SHClose SearchByDate(Date date);
	
	public List<SHClose> SearchTwoDayByDate(Date date);
}
