package com.design.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.design.service.api.IMoodService;
import com.design.service.model.MoodVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath://../spring-beans.xml")
public class TestMoodService {

	@Resource
	private IMoodService moodService;

	@SuppressWarnings("deprecation")
	@Test
	public void testShowDayMoodValue() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		MoodVO moodVO = moodService.ShowDayMoodValue(currentDate);
		System.out.println(moodVO.toString());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShowListMoodValue() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(0);
		currentDate.setDate(22);

		java.sql.Date enddate = new java.sql.Date(System.currentTimeMillis());
		enddate.setMonth(1);
		enddate.setDate(24);
		List<MoodVO> moodVO = moodService.ShowListMoodValue(currentDate,
				enddate);
		for (MoodVO m : moodVO) {
			System.out.println(m.toString());
		}
	}

}
