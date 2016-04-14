package com.design.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.design.service.api.INoteService;
import com.design.service.model.AuthorVO;
import com.design.service.model.NoteVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath://../spring-beans.xml")
public class TestNoteService {

	@Resource
	private INoteService noteService;

	@SuppressWarnings("deprecation")
	@Test
	public void testShowReading() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		List<NoteVO> list = noteService.ShowReading(currentDate);
		for (NoteVO noteVO : list) {
			System.out.println(noteVO.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShowComments() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		List<NoteVO> list = noteService.ShowComments(currentDate);
		for (NoteVO noteVO : list) {
			System.out.println(noteVO.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShowAuthor() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(23);
		List<AuthorVO> list = noteService.ShowAuthor(currentDate);
		for (AuthorVO authorVO : list) {
			System.out.println(authorVO.toString());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShowListNoteByDay() {
		java.sql.Date currentDate = new java.sql.Date(
				System.currentTimeMillis());
		currentDate.setMonth(1);
		currentDate.setDate(24);
		List<NoteVO> list = noteService.ShowListNoteByDay(currentDate);
		for (NoteVO noteVO : list) {
			System.out.println(noteVO.toString());
		}
	}

}
