package com.myEducation.inside.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myEducation.inside.dao.RoleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class RoleTest {
	
	@Autowired
	RoleDao roleDao;

	@Test
	public void test() {
//		System.out.println("角色。。。");
		Role role = new Role();
		role.setName("学生");
		role.setStatus(0);
		
		roleDao.insert(role);
	}

}
