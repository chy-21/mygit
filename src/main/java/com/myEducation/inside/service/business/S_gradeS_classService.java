package com.myEducation.inside.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.business.S_gradeS_classDao;
import com.myEducation.inside.model.business.S_gradeS_class;

@Service
public class S_gradeS_classService {

	@Autowired
	private S_gradeS_classDao s_gradeS_classDao;

	public List<Integer> getByG_id(int g_id) {
		return this.s_gradeS_classDao.getByG_id(g_id);
	}

	public void deleteByG_id(int g_id) {
		this.s_gradeS_classDao.deleteByG_id(g_id);
	}

	public void insert(S_gradeS_class s_gradeS_class) {
		this.s_gradeS_classDao.insert(s_gradeS_class);
	}

	public void update(S_gradeS_class s_gradeS_class) {
		this.s_gradeS_classDao.update(s_gradeS_class);
	}

}
