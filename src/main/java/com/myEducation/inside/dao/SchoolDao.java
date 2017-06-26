package com.myEducation.inside.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.School;
import com.myEducation.inside.utils.baseDao.BaseDao;
import com.myEducation.inside.utils.page.Page;

public interface SchoolDao extends BaseDao<School, Long>{

	//分页查询数据
	public List<School> selectByPage(Page<School> page);
	
	public School getbyName(@Param("name")String name);
	
	public List<HashMap<String,Object>> getAll();
	
}
