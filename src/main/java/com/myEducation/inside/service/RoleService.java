package com.myEducation.inside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.RoleDao;
import com.myEducation.inside.model.Role;
import com.myEducation.inside.utils.page.Page;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	public String selectNameByUserId(int userId){
		return this.roleDao.selectNameByUserId(userId);
	}
	
	public Page<Role> selectByPage(Page<Role> page){
		page.setData(this.roleDao.selectByPage(page));
		return page;
	}
	
	public List<Role> getAll(){
		return this.roleDao.getAll();
	}
	
	public Role selectById(Long id){
		return this.roleDao.getById(id);
	}
	
	public void insert(Role role){
		this.roleDao.insert(role);
	}
	
	public void update(Role role){
		this.roleDao.update(role);
	}
	
	public void delete(Long id){
		this.roleDao.delete(id);
	}
}
