package com.myEducation.inside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.UserRoleDao;
import com.myEducation.inside.model.UserRole;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	public void insert(UserRole userRole){
		this.userRoleDao.insert(userRole);
	}
	
	public void update(UserRole userRole){
		this.userRoleDao.update(userRole);
	}
	
	public void delete(int id){
		this.userRoleDao.delete(id);
	}
	
	public List<Integer> selectByUserId(int userId){
		return this.userRoleDao.selectByUserId(userId);
	}
	
}
