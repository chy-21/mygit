package com.myEducation.inside.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myEducation.inside.dao.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class StudentTest {
	
	@Autowired
	StudentDao studentDao;

	@Test
	public void test() {
//		System.out.println("student");
		Student student = new Student();
		student.setName("小明");
//		student.setOICQ("1340785888");
		student.setAge(12);
		student.setSex(0);
//		System.out.println(student.toString());
		
		studentDao.insert(student);
	}

}
