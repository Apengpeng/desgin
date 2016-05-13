package com.design.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.design.controller.NoteController;
import com.design.dao.api.ITitleDao;
import com.design.dao.model.Title;
import com.design.service.model.AuthorVO;
import com.design.service.model.NoteVO;
import com.design.service.model.TNoteVO;

@Repository("titleDao")
public class TitleDaoImpl implements ITitleDao {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	/**
	 * 获取阅读量排名前五的帖子
	 */
	@Override
	public List<Title> SearchTop5ByReading(Date date) {
		String sql = "SELECT Id,Title,PublishDate,Reading FROM mood_base.note where PublishDate='"
				+ date + "' order by Reading desc limit 5;";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		List<Title> list = new ArrayList<Title>();
		Title title = null;
		while (rs.next()) {
			title = new Title();
			title.setId(rs.getInt("Id"));
			title.setTitle(rs.getString("Title"));
			title.setPublish_date(rs.getDate("PublishDate"));
			title.setReading(rs.getInt("Reading"));
			list.add(title);
		}
		return list;
	}

	@Override
	public List<Title> SearchTop5ByComments(Date date) {
		String sql = "SELECT Id,Title,PublishDate,Comment FROM mood_base.note where PublishDate='"
				+ date + "' order by Comment desc limit 5;";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		List<Title> list = new ArrayList<Title>();
		Title title = null;
		while (rs.next()) {
			title = new Title();
			title.setId(rs.getInt("Id"));
			title.setTitle(rs.getString("Title"));
			title.setPublish_date(rs.getDate("PublishDate"));
			title.setComment(rs.getInt("Comment"));
			list.add(title);
		}
		return list;
	}

	@Override
	public List<AuthorVO> SearchTop5ByAuthor(Date date) {
		String sql = "select Author,count(*) as sumAuthor from mood_base.note where PublishDate = '"
				+ date
				+ "' group by Author having Author!='[]' order by sumAuthor desc limit 5 ;";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		List<AuthorVO> list = new ArrayList<AuthorVO>();
		AuthorVO author = null;
		while (rs.next()) {
			author = new AuthorVO();
			author.setAuthor(rs.getString("Author"));
			author.setCount(rs.getInt("sumAuthor"));
			list.add(author);
		}
		return list;
	}

	@Override
	public List<NoteVO> SearchByDay(Date date) {
		int head = (NoteController.PAGE_SIZE - 1) * NoteController.NOTE_PAGE;
		int page_size = NoteController.PAGE_SIZE;
		String sql = "select b.PublishDate as publishDate ,b.id as id,a.value as value,b.Title as title,b.Reading as reading,"
				+ "b.Comment as comment from mood_collection.notemood as a,mood_base.note as b where a.id=b.id and b.PublishDate='"
				+ date + "' limit " + head + "," + page_size + ";";
		System.out.println(sql);
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		List<NoteVO> list = new ArrayList<NoteVO>();
		NoteVO noteVO = null;
		while (rs.next()) {
			noteVO = new NoteVO();
			noteVO.setId(rs.getInt("id"));
			noteVO.setTitle(rs.getString("title"));
			noteVO.setDate(rs.getDate("publishDate"));

			noteVO.setMoodValue(rs.getFloat("value"));
			noteVO.setReading(rs.getInt("reading"));
			noteVO.setComments(rs.getInt("comment"));
			list.add(noteVO);
		}
		return list;
	}

	@Override
	public TNoteVO SumNoteByDay(Date date) {
		String sql = "SELECT DateTime,DayMoodValue,DayNoteReading,DayNoteComment,DayNewNoteSum FROM mood_collection.daymood where DateTime='"
				+ date + "';";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		TNoteVO tNoteVO = null;
		if (rs.next()) {
			tNoteVO = new TNoteVO();
			tNoteVO.setDate(rs.getDate("DateTime"));
			tNoteVO.setReading(rs.getInt("DayNoteReading"));
			tNoteVO.setComments(rs.getInt("DayNoteComment"));
			tNoteVO.setCreate(rs.getInt("DayNewNoteSum"));
			tNoteVO.setMoodvalue(rs.getFloat("DayMoodValue"));
		}
		return tNoteVO;
	}

	@Override
	public List<TNoteVO> ListSumNote(Date begin, Date end) {
		String sql = "SELECT DateTime,DayMoodValue,DayNoteReading,DayNoteComment,DayNewNoteSum FROM mood_collection.daymood where DateTime Between '"
				+ begin + "' and '" + end + "' order by DateTime asc;";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		List<TNoteVO> list = new ArrayList<TNoteVO>();
		TNoteVO tNoteVO = null;
		while (rs.next()) {
			tNoteVO = new TNoteVO();
			tNoteVO.setDate(rs.getDate("DateTime"));
			tNoteVO.setReading(rs.getInt("DayNoteReading"));
			tNoteVO.setComments(rs.getInt("DayNoteComment"));
			tNoteVO.setCreate(rs.getInt("DayNewNoteSum"));
			tNoteVO.setMoodvalue(rs.getFloat("DayMoodValue"));
			list.add(tNoteVO);
		}
		return list;
	}

	@Override
	public int CountNoteByDate(Date time) {
		String sql = "SELECT count(*) as sum FROM mood_base.note where publishDate='"
				+ time + "';";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		int sum = 0;
		if (rs.next()) {
			sum = rs.getInt("sum");
		} else {
			sum = 0;
		}
		return sum;
	}

}
