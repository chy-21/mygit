package com.myEducation.inside.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.User;
import com.myEducation.inside.utils.baseDao.BaseDao;
import com.myEducation.inside.utils.page.Page;

public interface UserDao extends BaseDao<User, Long>{
	
	// 分页查询显示
	public List<User> selectByPage(Page<User> page);

	public User getbyName(@Param("username") String username);
	
	public void updatePwd(User user); 
	
}
