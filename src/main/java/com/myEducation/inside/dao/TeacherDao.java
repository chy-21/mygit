package com.myEducation.inside.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.Teacher;
import com.myEducation.inside.utils.baseDao.BaseDao;
import com.myEducation.inside.utils.page.Page;

public interface TeacherDao extends BaseDao<Teacher, Long> {
	// 分页查询显示
	public List<Teacher> selectByPage(Page<Teacher> page);
	
	public Teacher getbyName(@Param("name") String name);
	
	public List<HashMap<String,Object>> getAll();
	
}
