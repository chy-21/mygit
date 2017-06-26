package com.myEducation.inside.dao;

import java.util.HashMap;
import java.util.List;

import com.myEducation.inside.model.S_class;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface S_classDao extends BaseDao<S_class, Long> {

	public List<HashMap<String,Object>> getAll();
	
}
