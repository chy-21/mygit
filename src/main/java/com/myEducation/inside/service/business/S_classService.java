package com.myEducation.inside.service.business;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.business.S_classDao;

@Service
public class S_classService {

	@Autowired
	private S_classDao s_classDao;
	
	public List<HashMap<String,Object>> getAll(){
		return this.s_classDao.getAll();
	}
	
}
