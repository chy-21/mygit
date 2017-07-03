package com.myEducation.inside.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.business.Student;
import com.myEducation.inside.utils.baseDao.BaseDao;
import com.myEducation.inside.utils.page.Page;

public interface StudentDao extends BaseDao<Student, Long>{

	//分页查询显示
	public List<Student> selectByPage(Page<Student> page);
	
	public Student getbyName(@Param("name")String name);
	
}
