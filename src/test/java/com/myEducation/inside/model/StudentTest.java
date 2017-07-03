package com.myEducation.inside.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myEducation.inside.dao.business.StudentDao;
import com.myEducation.inside.model.business.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class StudentTest {
	
	@Autowired
	StudentDao studentDao;

	@Test
	public void test() {
//		name,sex,age,province,nation,s_id,g_id,c_id,entrytime,updatetime
//		System.out.println("student");
		Student student = new Student();
		student.setName("小明");
		student.setSex("女");
		student.setAge(12);
		student.setProvince("福建省");
		student.setNation("汉族");
		student.setS_id(1);
		student.setG_id(1);
		student.setC_id(1);
		System.out.println(student.toString());
		
		studentDao.insert(student);
	}

}
