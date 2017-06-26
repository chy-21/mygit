package com.myEducation.inside.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.Menu;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface MenuDao extends BaseDao<Menu,Integer> {
	
	public List<Menu> getAll();
	
	public List<Menu> getByRoleId(@Param("roleId")int roleId);
	
}
