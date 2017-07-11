package com.myEducation.inside.dao.business;

import java.util.HashMap;
import java.util.List;

import com.myEducation.inside.model.business.S_grade;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface S_gradeDao extends BaseDao<S_grade, Integer>{

	public List<HashMap<String,Object>> getAll();
	
}
