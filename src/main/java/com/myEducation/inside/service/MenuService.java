package com.myEducation.inside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.MenuDao;
import com.myEducation.inside.model.Menu;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> getAll(){
		return this.menuDao.getAll();
	}
	
	public List<Menu> getByRoleId(int roleId){
		return this.menuDao.getByRoleId(roleId);
	}
}
