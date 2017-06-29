package com.myEducation.inside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.PremissionDao;

@Service
public class PremissionService {

	@Autowired
	private PremissionDao premissionDao;
	
	public void delete(Long id){
		this.premissionDao.delete(id);
	}
}
