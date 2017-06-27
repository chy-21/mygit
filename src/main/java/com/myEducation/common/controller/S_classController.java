package com.myEducation.common.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.service.S_classService;

@Controller
@RequestMapping("${mainPath}/manager/s_class")
public class S_classController {

	@Autowired
	private S_classService s_classService;
	
	@RequestMapping("autoClass")
	@ResponseBody
	public List<HashMap<String, Object>> getAll(){
		return s_classService.getAll();
	}
}
