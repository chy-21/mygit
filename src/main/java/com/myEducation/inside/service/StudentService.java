package com.myEducation.inside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.StudentDao;
import com.myEducation.inside.model.Student;
import com.myEducation.inside.utils.page.Page;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public void insert(Student student){
		this.studentDao.insert(student);
	}
	
	public void update(Student student){
		this.studentDao.update(student);
	}
	
	public void delete(Long id){
		this.studentDao.delete(id);
	}
	
	public Page<Student> selectByPage(Page<Student> page){
		page.setData(this.studentDao.selectByPage(page));
		return page;
	}
	
	public Student getByName(String name){
		return this.studentDao.getbyName(name);
	}
	
	public Student getById(Long id){
		return this.studentDao.getById(id);
	}
}
