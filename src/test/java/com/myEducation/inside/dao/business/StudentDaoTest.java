package com.myEducation.inside.dao.business;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myEducation.inside.model.business.Student;
import com.myEducation.inside.utils.page.Page;

public class StudentDaoTest {

	@Autowired
	StudentDao s;
	
	@Test
	public void test() {
		System.out.println(".......................");
		
		Page<Student> page = null;
		s.selectByPage(page);
	}

}
