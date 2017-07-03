package com.myEducation.common.controller.business;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.model.business.Teacher;
import com.myEducation.inside.service.business.TeacherService;
import com.myEducation.inside.utils.Result;
import com.myEducation.inside.utils.ResultStatus;
import com.myEducation.inside.utils.page.Page;

@Controller
@RequestMapping("${mainPath}/business/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping
	public String index(){
		return "main/business/teacher-list";
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public Page<Teacher> data(Page<Teacher> page){
		return this.teacherService.selectByPage(page);
	}
	
	@RequestMapping("edit")
	public String add(){
		return "main/business/teacher-edit";
	}
	
	@RequestMapping(value="edit/{tId}",method=RequestMethod.GET)
	public String edit(@PathVariable("tId")Long id,Model model){
		model.addAttribute("teacher", this.teacherService.getById(id));
		return "main/business/teacher-edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> tEdit(Teacher teacher){
		Result<String> result = new Result<String>();
		try {
			if (teacher.getId() == null) {
				this.teacherService.insert(teacher);
			}else {
				Teacher t_id = this.teacherService.getById(teacher.getId());
				if (t_id == null) {
					result.setStatus(ResultStatus.DATA_EXISTS);
					return result;
				}
				t_id.setName(teacher.getName());
				t_id.setSex(teacher.getSex());
				t_id.setAge(teacher.getAge());
				t_id.setSynopsis(teacher.getSynopsis());
				t_id.setS_id(teacher.getS_id());
				t_id.setG_id(teacher.getG_id());
				t_id.setC_id(teacher.getC_id());
				this.teacherService.update(t_id);
			}
			result.setStatus(ResultStatus.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setStatus(ResultStatus.FAIL);
			result.setContent(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(Teacher teacher){
		this.teacherService.delete(teacher.getId());
		return "main/business/teacher-list";
	}
	
	@RequestMapping("autoTeacher")
	@ResponseBody
	public List<HashMap<String, Object>> getTeacherAll(){
		return teacherService.getAll();
	}
}
