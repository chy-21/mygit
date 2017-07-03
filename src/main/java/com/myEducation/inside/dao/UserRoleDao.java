package com.myEducation.inside.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.UserRole;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface UserRoleDao extends BaseDao<UserRole, Integer>{

	public List<Integer> selectByUserId(@Param("userId")int userId);
	
}
