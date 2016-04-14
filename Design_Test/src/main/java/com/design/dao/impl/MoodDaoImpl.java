package com.design.dao.impl;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.design.dao.api.IMoodDao;
import com.design.dao.model.Mood;

@Repository("mooddao")
public class MoodDaoImpl implements IMoodDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Mood> list(Date begintime, Date endtime) {
		String sql = "SELECT id,DateTime,DayMoodValue FROM mood_collection.daymood where  DateTime Between '"
				+ begintime + "' and '"+endtime+"';";
		System.out.println(sql);
		List<Mood> list = new LinkedList<Mood>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		Mood mood = null;
		while (rs.next()) {
			mood = new Mood();
			mood.setId(rs.getInt("id"));
			mood.setDate(rs.getDate("DateTime"));
			mood.setValue(rs.getFloat("DayMoodValue"));
			list.add(mood);
		}
		return list;
	}

	@Override
	public Mood getDayMoodValueByDay(Date date) {
		String sql = "SELECT id,DateTime,DayMoodValue FROM mood_collection.daymood where DateTime='"
				+ date + "';";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		Mood mood = new Mood();
		mood.setDate(date);
		if (rs.next()) {
			mood.setId(rs.getInt("id"));
			mood.setValue(rs.getFloat("DayMoodValue"));
		} else {
			mood.setValue(0);
		}
		return mood;
	}

	@Override
	public List<Mood> getTwoDayMoodValue(Date date) {
		String sql = "SELECT id,DateTime,DayMoodValue FROM mood_collection.daymood where DateTime<='"
				+ date + "' order by DateTime desc limit 2;";
		List<Mood> list = new LinkedList<Mood>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		Mood mood = null;
		// 添加当天数据
		if (rs.next()) {
			mood = new Mood();
			mood.setId(rs.getInt("id"));
			mood.setDate(rs.getDate("DateTime"));
			mood.setValue(rs.getFloat("DayMoodValue"));
			list.add(mood);
		} else {
			list.add(new Mood());
		}
		// 添加前一天数据
		if (rs.next()) {
			mood = new Mood();
			mood.setId(rs.getInt("id"));
			mood.setDate(rs.getDate("DateTime"));
			mood.setValue(rs.getFloat("DayMoodValue"));
			list.add(mood);
		} else {
			list.add(new Mood());
		}
		return list;
	}

}
