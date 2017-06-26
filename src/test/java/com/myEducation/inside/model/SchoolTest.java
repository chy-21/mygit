package com.myEducation.inside.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myEducation.inside.dao.SchoolDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class SchoolTest {
	
	@Autowired
	SchoolDao sDao;

	@Test
	public void test() {
//		System.out.println("school");
		School s = new School();
		s.setName("小蕊培训中心");
		s.setHeadmaster("小蕊");
		s.setSynopsis("让你的孩子更有气质 ");
		s.setAddress("恒大城");
		
		sDao.insert(s);
	}

}
