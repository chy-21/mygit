package com.myEducation.inside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.DictDao;
import com.myEducation.inside.model.Dict;

@Service
public class DictService {

	@Autowired
	private DictDao dictDao;
	
	public List<Dict> selectByType(String type){
		return this.dictDao.selectByType(type);
	}
}
