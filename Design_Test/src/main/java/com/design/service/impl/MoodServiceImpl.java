package com.design.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.design.dao.api.IMoodDao;
import com.design.dao.api.ISHCloseDao;
import com.design.dao.model.Mood;
import com.design.dao.model.SHClose;
import com.design.service.api.IMoodService;
import com.design.service.model.MoodVO;

@Service("moodService")
public class MoodServiceImpl implements IMoodService {

	@Resource
	private IMoodDao moodDao;

	@Resource
	private ISHCloseDao ishCloseDao;

	@Override
	public MoodVO ShowDayMoodValue(Date date) {
		MoodVO moodVO = new MoodVO();

		List<Mood> mood = moodDao.getTwoDayMoodValue(date);
		moodVO.setDate(date);
		moodVO.setMoodValue(mood.get(0).getValue());
		moodVO.setMoodValueChange((mood.get(0).getValue() - mood.get(1).getValue())
				/ mood.get(1).getValue());

		List<SHClose> shClose = ishCloseDao.SearchTwoDayByDate(date);
		moodVO.setShcloseValue(shClose.get(0).getValue());
		moodVO.setShcloseValueChange((shClose.get(1).getValue()-shClose.get(0).getValue())/shClose.get(0).getValue());
		
		return moodVO;
	}

	@Override
	public List<MoodVO> ShowListMoodValue(Date begin, Date end) {

		List<Mood> moodList = moodDao.list(begin, end);
		List<SHClose> shCloseList = ishCloseDao.list(begin, end);

		List<MoodVO> moodVOList = new ArrayList<MoodVO>();
		MoodVO moodVO = null;
		for (int i = 0; i < moodList.size(); i++) {
			moodVO = new MoodVO();
			moodVO.setDate(moodList.get(i).getDate());
			moodVO.setMoodValue(moodList.get(i).getValue());
			moodVO.setShcloseValue(shCloseList.get(i).getValue());
			moodVOList.add(moodVO);
		}

		return moodVOList;
	}
}
