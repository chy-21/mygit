package com.myEducation.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myEducation.inside.utils.Constant;

@Controller
public class LoginController extends BaseController {
	
//	@Autowired
//	private UserService userService;
	
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
	
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	@ResponseBody
//	public Result<?> userLogin(User user, HttpServletRequest request){
//		Result<String> result = new Result<String>();
//		if (condition) {
//			
//		}
//		return result;
//	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constant.LOGIN_USER);
		return "login";
	}

}
