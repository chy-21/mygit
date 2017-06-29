package com.myEducation.inside.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.Premission;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface PremissionDao extends BaseDao<Premission, Long> {

	// 根据多个角色查询权限
	public List<String> getByRoles(List<Integer> roles);

	// 根据角色id删除角色权限
	public void deleteByRoleId(@Param("roleId") int roleId);

	// 根据角色id批量设置权限
	public void insertByList(HashMap<String, Object> map);

}
