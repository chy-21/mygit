package com.myEducation.common.controller.business;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.service.S_gradeService;

@Controller
@RequestMapping("${mainPath}/manager/s_grade")
public class S_gradeController {

	@Autowired
	private S_gradeService s_gradeService;
	
	@RequestMapping("autoGrade")
	@ResponseBody
	public List<HashMap<String, Object>> getAll(){
		return s_gradeService.getAll();
	}
}
