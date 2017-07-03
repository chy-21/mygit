package com.myEducation.inside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEducation.inside.dao.UserDao;
import com.myEducation.inside.model.User;
import com.myEducation.inside.utils.MD5Utils;
import com.myEducation.inside.utils.page.Page;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void insert(User user) {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		user.setStatus(0);
		this.userDao.insert(user);
	}

	public void update(User user) {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		this.userDao.update(user);
	}

	public void delete(Integer id) {
		this.userDao.delete(id);
	}

	public void updatePwd(User user) {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		this.userDao.updatePwd(user);
	}

	public Page<User> selectByPage(Page<User> page) {
		page.setData(this.userDao.selectByPage(page));
		return page;
	}
	
	public User getById(Integer id){
		return this.userDao.getById(id);
	}
	
	public User getByName(String username){
		return this.userDao.getByName(username);
	}
	
}