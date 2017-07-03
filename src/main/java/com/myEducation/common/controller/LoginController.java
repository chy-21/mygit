package com.myEducation.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.model.User;
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
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> login(User user ,HttpServletRequest request,boolean rememberMe){
		Result<String> result = new Result<String>();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword(),rememberMe);
		Subject currentUser = SecurityUtils.getSubject();  
		
		try {
			 currentUser.login(token); 
		} catch(UnknownAccountException uae){  
            result.setStatus(ResultStatus.ACCOUNT_NOTFOUND);
        }catch(IncorrectCredentialsException ice){  
            result.setStatus(ResultStatus.PASSWORD_ERROR);
        }catch(AuthenticationException ae){  
        	ae.printStackTrace();
            result.setStatus(ResultStatus.FAIL);
            result.setContent(ae.getMessage());
        }  
		return result;
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		Subject currentUser = SecurityUtils.getSubject();  
		if(currentUser.getSession() != null){
			currentUser.logout();
		}
		return "login";
	}

}
