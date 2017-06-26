package com.myEducation.inside.dao;

import java.util.HashMap;
import java.util.List;

import com.myEducation.inside.model.S_grade;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface S_gradeDao extends BaseDao<S_grade, Long>{
	
	public List<HashMap<String,Object>> getAll();

}
