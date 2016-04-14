package com.design.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.design.dao.api.ITitleDao;
import com.design.dao.model.Title;
import com.design.service.model.AuthorVO;
import com.design.service.model.NoteVO;
import com.design.service.model.TNoteVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath://../spring-beans.xml")
public class TestTitleDao {

	@Resource
	private ITitleDao titleDao;

	@SuppressWarnings("deprecation")
	@Test
	public void testSearchTop5ByReading() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(25);
		List<Title> list = titleDao.SearchTop5ByReading(currentDate);
		for (Title title : list) {
			System.out.println(title.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSearchTop5ByComments() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(25);
		List<Title> list = titleDao.SearchTop5ByComments(currentDate);
		for (Title title : list) {
			System.out.println(title.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSearchTop5ByAuthor() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(26);
		List<AuthorVO> list = titleDao.SearchTop5ByAuthor(currentDate);
		for (AuthorVO author : list) {
			System.out.println(author.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSearchByDay() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(24);
		List<NoteVO> list = titleDao.SearchByDay(currentDate);
		for (NoteVO author : list) {
			System.out.println(author.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSumNoteByDay() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(24);
		TNoteVO list = titleDao.SumNoteByDay(currentDate);
		System.out.println(list.toString());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testListSumNote() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(24);

		java.sql.Date enddate = new java.sql.Date(System.currentTimeMillis());
		enddate.setMonth(1);
		enddate.setDate(26);
		List<TNoteVO> list = titleDao.ListSumNote(currentDate, enddate);
		for (TNoteVO t : list) {
			System.out.println(t.toString());
		}
	}

}
