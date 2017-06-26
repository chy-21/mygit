package com.myEducation.inside.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.SchoolDao;
import com.myEducation.inside.model.School;
import com.myEducation.inside.utils.page.Page;

@Service
public class SchoolService {

	@Autowired
	private SchoolDao schoolDao;
	
	public void insert(School school){
		this.schoolDao.insert(school);
	}
	
	public void update(School school){
		this.schoolDao.update(school);
	}
	
	public void delete(Long id){
		this.schoolDao.delete(id);
	}
	
	public School getById(Long id){
		return this.schoolDao.getById(id);
	}
	
	public Page<School> selectByPage(Page<School> page){
		page.setData(this.schoolDao.selectByPage(page));
		return page;
	}
	
	public School getByName(String name){
		return this.schoolDao.getbyName(name);
	}
	
	public List<HashMap<String, Object>> getAll(){
		return this.schoolDao.getAll();
	}
}
