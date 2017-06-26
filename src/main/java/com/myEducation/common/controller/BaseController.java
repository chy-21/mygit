package com.myEducation.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.myEducation.inside.model.User;
import com.myEducation.inside.utils.Constant;

@Controller
public class BaseController {

	@Autowired
	private HttpServletRequest request;

	public User getUser() {
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		return user;
	}

}
