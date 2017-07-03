package com.myEducation.inside.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myEducation.inside.dao.business.TeacherDao;
import com.myEducation.inside.model.business.Teacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TeacherTest {
	
	@Autowired
	TeacherDao tDao;

	@Test
	public void test() {
//		System.out.println("teacher");
		Teacher t = new Teacher();
		t.setName("小蕊");
//		t.setSex(1);
		t.setAge(29);
		t.setSynopsis("性格开朗，为人正直");
		t.setS_id((long)1);
		
		tDao.insert(t);
	}

}
