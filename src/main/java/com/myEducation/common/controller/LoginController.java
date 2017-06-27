package com.myEducation.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.model.User;
import com.myEducation.inside.utils.Constant;
import com.myEducation.inside.utils.MD5Utils;
import com.myEducation.inside.utils.Result;
import com.myEducation.inside.utils.ResultStatus;

@Controller
public class LoginController extends BaseController {
	
	@RequestMapping("")
	public String index(){
		if(getUser() != null){
			return "redirect:main";
		}
		return "login";
	}
	
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		if(getUser() != null){
			return "redirect:main";
		}
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Result<?> userLogin(User user, HttpServletRequest request){
		Result<String> result = new Result<String>();
		User u_id = getUser();
		if (!user.getUsername().equals(u_id.getUsername())) {
			result.setStatus(ResultStatus.ACCOUNT_NOTFOUND);
		}
		if (!user.getPassword().toUpperCase().equals(MD5Utils.md5(u_id.getPassword().toUpperCase()))) {
			result.setStatus(ResultStatus.USER_PASSWORD_ERROR);
		}
		return result;
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constant.LOGIN_USER);
		return "login";
	}

}
