package com.myEducation.inside.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.Role;
import com.myEducation.inside.utils.baseDao.BaseDao;
import com.myEducation.inside.utils.page.Page;

public interface RoleDao extends BaseDao<Role, Long>{
	
	public List<Role> selectByPage(Page<Role> page);
	
	public List<Role> getAll();
	
	public String selectNameByUserId(@Param("userId")int userId);
}
