package com.myEducation.inside.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.S_gradeDao;

@Service
public class S_gradeService {

	@Autowired
	private S_gradeDao s_gradeDao;
	
	public List<HashMap<String, Object>> getAll(){
		return this.s_gradeDao.getAll();
	}
	
}
