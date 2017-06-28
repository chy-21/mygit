package com.myEducation.inside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.AchievementDao;
import com.myEducation.inside.model.Achievement;
import com.myEducation.inside.utils.page.Page;

@Service
public class AchievementService {

	@Autowired
	private AchievementDao achievementDao;
	
	public Page<Achievement> selectByPage(Page<Achievement> page){
		page.setData(this.achievementDao.selectByPage(page));
		return page;
	}
	
	public Achievement getById(Long id){
		return this.achievementDao.getById(id);
	}
	
	public Achievement getByStuId(Long stu_id){
		return achievementDao.getById(stu_id);
	}
	
	public void insert(Achievement achievement){
		this.achievementDao.insert(achievement);
	}
	
	public void update(Achievement achievement){
		this.achievementDao.update(achievement);
	}
	
	public void dalete(Long  id){
		this.achievementDao.delete(id);
	}
	
}
