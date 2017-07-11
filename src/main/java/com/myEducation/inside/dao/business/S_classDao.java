package com.myEducation.inside.dao.business;

import java.util.HashMap;
import java.util.List;

import com.myEducation.inside.model.business.S_class;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface S_classDao extends BaseDao<S_class, Integer>{

	public List<HashMap<String,Object>> getAll();
	
}
