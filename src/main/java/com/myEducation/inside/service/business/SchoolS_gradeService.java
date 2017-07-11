package com.myEducation.inside.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.business.SchoolS_gradeDao;
import com.myEducation.inside.model.business.SchoolS_grade;

@Service
public class SchoolS_gradeService {

	@Autowired
	private SchoolS_gradeDao schoolS_gradeDao;
	
	public List<Integer> getByS_id(int s_id){
		return this.schoolS_gradeDao.getByS_id(s_id);
	}
	
	public void deleteByS_id(int s_id){
		this.schoolS_gradeDao.deleteByS_id(s_id);
	}
	
	public void insert(SchoolS_grade schoolS_grade){
		this.schoolS_gradeDao.insert(schoolS_grade);
	}
	
	public void update(SchoolS_grade schoolS_grade){
		this.schoolS_gradeDao.update(schoolS_grade);
	}
	
}
