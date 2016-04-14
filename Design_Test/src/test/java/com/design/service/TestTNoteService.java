package com.design.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.design.service.api.ITNoteService;
import com.design.service.model.TNoteVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath://../spring-beans.xml")
public class TestTNoteService {

	@Resource
	private ITNoteService tNoteService;

	@SuppressWarnings("deprecation")
	@Test
	public void testShowDayNote() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		TNoteVO t = tNoteService.ShowDayNote(currentDate);
		System.out.println(t.toString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testShowListDayNote() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(24);

		java.sql.Date enddate = new java.sql.Date(System.currentTimeMillis());
		enddate.setMonth(1);
		enddate.setDate(26);
		
		List<TNoteVO> t = tNoteService.ShowListDayNote(currentDate, enddate);
		for(TNoteVO tnoteVO:t){
			System.out.println(tnoteVO.toString());
		}
	}
	
	
}
