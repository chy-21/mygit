package com.myEducation.inside.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.TeacherDao;
import com.myEducation.inside.model.Teacher;
import com.myEducation.inside.utils.page.Page;

@Service
public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	public void insert(Teacher teacher){
		this.teacherDao.insert(teacher);
	}
	
	public void update(Teacher teacher){
		this.teacherDao.update(teacher);
	}
	
	public void delete(Long id) {
		this.teacherDao.delete(id);
	}
	
	public Teacher getById(Long id){
		return this.teacherDao.getById(id);
	}
	
	public Page<Teacher> selectByPage(Page<Teacher> page){
		page.setData(this.teacherDao.selectByPage(page));
		return page;
	}
	
	public Teacher getByName(String name){
		return this.teacherDao.getbyName(name);
	}
	
	public List<HashMap<String, Object>> getAll(){
		return this.teacherDao.getAll();
	}
}
