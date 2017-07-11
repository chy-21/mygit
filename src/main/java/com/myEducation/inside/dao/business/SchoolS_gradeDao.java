package com.myEducation.inside.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.business.SchoolS_grade;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface SchoolS_gradeDao extends BaseDao<SchoolS_grade, Integer>{

	public List<Integer> getByS_id(@Param("s_id")int s_id);
	
	public void deleteByS_id(@Param("s_id")int s_id);
	
}
