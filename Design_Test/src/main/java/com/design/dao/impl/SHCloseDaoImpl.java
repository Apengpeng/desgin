package com.design.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.design.dao.api.ISHCloseDao;
import com.design.dao.model.SHClose;


@Repository("shclosedao")
public class SHCloseDaoImpl implements ISHCloseDao {
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<SHClose> list(Date begintime, Date endtime) {

		String sql = "select Id,DateTime,CloseValue FROM mood_base.shindex where DateTime Between '"
				+ begintime + "' and '" + endtime + "';";
        System.out.println(sql);
		List<SHClose> list = new LinkedList<SHClose>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		SHClose shclose = null;
		while (rs.next()) {
			shclose = new SHClose();
			shclose.setId(rs.getInt("Id"));
			shclose.setDate(rs.getDate("DateTime"));
			shclose.setValue(rs.getFloat("CloseValue"));
			list.add(shclose);
		}
		return list;
	}

	@Override
	public SHClose SearchByDate(Date date) {
		String sql = "SELECT Id,DateTime,CloseValue FROM mood_base.shindex where DateTime='"+date+"';";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		SHClose shclose =  new SHClose();
		if (rs.next()) {
			shclose.setId(rs.getInt("Id"));
			shclose.setDate(rs.getDate("DateTime"));
			shclose.setValue(rs.getFloat("CloseValue"));
		}
		return shclose;
	}

	@Override
	public List<SHClose> SearchTwoDayByDate(Date date) {
		String sql = "SELECT Id,DateTime,CloseValue FROM mood_base.shindex where DateTime<'"+date+"' order by DateTime desc limit 2;";
		System.out.println(sql);
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		List<SHClose> list = new ArrayList<SHClose>();
		SHClose shclose = null;
		if (rs.next()) {
			shclose =  new SHClose();
			shclose.setId(rs.getInt("Id"));
			shclose.setDate(rs.getDate("DateTime"));
			shclose.setValue(rs.getFloat("CloseValue"));
			list.add(shclose);
		}else{
			shclose =  new SHClose();
			list.add(shclose);
		}
		
		if (rs.next()) {
			shclose =  new SHClose();
			shclose.setId(rs.getInt("Id"));
			shclose.setDate(rs.getDate("DateTime"));
			shclose.setValue(rs.getFloat("CloseValue"));
			list.add(shclose);
		}else{
			shclose =  new SHClose();
			list.add(shclose);
		}
		return list;
	}

}
