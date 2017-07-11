package com.myEducation.inside.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.business.S_gradeS_class;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface S_gradeS_classDao extends BaseDao<S_gradeS_class, Integer>{

	public List<Integer> getByG_id(@Param("g_id")int g_id);
	
	public void deleteByG_id(@Param("g_id")int g_id);
	
}
