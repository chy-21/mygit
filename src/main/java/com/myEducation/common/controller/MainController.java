package com.myEducation.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${mainPath}")
public class MainController {

	@RequestMapping("")
	public String main(){
		return "main/index";
	}
}
