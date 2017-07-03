package com.myEducation.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.model.User;
import com.myEducation.inside.service.UserService;
import com.myEducation.inside.utils.Result;
import com.myEducation.inside.utils.ResultStatus;
import com.myEducation.inside.utils.page.Page;

@Controller
@RequestMapping("${mainPath}/manager/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String user(){
		return "main/manager/user-list";
	}
	
	@RequestMapping("data")
	@ResponseBody
	public Page<User> userPage(Page<User> page){
		return userService.selectByPage(page);
	}
	
	@RequestMapping("edit")
	public String add(){
		return "main/manager/user-edit";
	}
	
	@RequestMapping("edit/{userId}")
	public String edit(@PathVariable("userId")Integer userId,Model model){
		model.addAttribute("user",this.userService.getById(userId));
		return "main/manager/user-edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> userEdit(User user){
		Result<String> result = new Result<String>();
		try {
			if (user.getId() == null) {
				this.userService.insert(user);
			}else{
				User u_id = this.userService.getById(user.getId());
				if (u_id == null) {
					result.setStatus(ResultStatus.ACCOUNT_NOTFOUND);
					return result;
				}
				u_id.setUsername(user.getUsername());
				u_id.setPassword(user.getPassword());
				this.userService.update(u_id);
			}
			result.setStatus(ResultStatus.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setStatus(ResultStatus.FAIL);
			result.setContent(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="status",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> userStatus(User user){
		Result<String> result = new Result<String>();
		try {
			User u_id = this.userService.getById(user.getId());
			if (u_id == null) {
				result.setStatus(ResultStatus.DATA_NOTFOUND);
				return result;
			}
			u_id.setStatus(user.getStatus());
			this.userService.update(u_id);
			result.setStatus(ResultStatus.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setStatus(ResultStatus.FAIL);
			result.setContent(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String userDelete(User user){
		userService.delete(user.getId());
		return "main/manager/user-list";
	}
}
