package com.myEducation.inside.dao;

import java.util.HashMap;
import java.util.List;

import com.myEducation.inside.model.Achievement;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface AchievementDao extends BaseDao<Achievement, Long>{

	public List<HashMap<String,Object>> getAll();
	
}
