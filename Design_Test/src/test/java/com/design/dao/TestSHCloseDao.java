package com.design.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.design.dao.api.ISHCloseDao;
import com.design.dao.model.SHClose;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath://../spring-beans.xml")
public class TestSHCloseDao {


	@Resource
	private ISHCloseDao shclosedao;

	@SuppressWarnings("deprecation")
	@Test
	public void testSearchByID() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		SHClose shclose = shclosedao.SearchByDate(currentDate);
		System.out.println(shclose.toString());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void SearchTwoDayByDate() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		List<SHClose> shclose = shclosedao.SearchTwoDayByDate(currentDate);
		for (SHClose s : shclose) {
			System.out.println(s.toString());
		}

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testlist() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(0);
		currentDate.setDate(23);
		java.sql.Date enddate = new java.sql.Date(
				System.currentTimeMillis());
		enddate.setMonth(2);
		enddate.setDate(23);
		List<SHClose> shclose = shclosedao.list(currentDate, enddate);
		for (SHClose s : shclose) {
			System.out.println(s.toString());
		}

	}
}
