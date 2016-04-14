package com.design.dao;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.design.dao.api.IMoodDao;
import com.design.dao.model.Mood;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath://../spring-beans.xml")
public class TestMoodDao {
	private static Logger logger = LoggerFactory.getLogger(TestMoodDao.class);
	
	@Resource
	private IMoodDao moodDao;

	@SuppressWarnings("deprecation")
	@Test
	public void testMood(){
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		System.out.println(currentDate);
		Mood mood = moodDao.getDayMoodValueByDay(currentDate);
		System.out.println("#############返回数据###############");
		System.out.println(mood.toString());
		logger.info("success");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testListMood(){
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		List<Mood> mood = moodDao.getTwoDayMoodValue(currentDate);
		System.out.println("#############返回数据###############");
		for(Mood m:mood){
			System.out.println(m.toString());
		}
		
		logger.info("success");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRangeMood(){
		
		java.sql.Date begintime = new java.sql.Date(System.currentTimeMillis());
		begintime.setMonth(0);
		begintime.setDate(26);
		
		java.sql.Date endtime = new java.sql.Date(System.currentTimeMillis());
		endtime.setMonth(4);
		endtime.setDate(23);
		
		System.out.println("begintime:"+begintime+" endtime:"+endtime);
		List<Mood> mood = moodDao.list(begintime, endtime);
		System.out.println("#############返回数据###############");
		for(Mood m:mood){
			System.out.println(m.toString());
		}
		
		logger.info("success");
	}
}
