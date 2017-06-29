package com.myEducation.common.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.model.School;
import com.myEducation.inside.service.SchoolService;
import com.myEducation.inside.utils.Result;
import com.myEducation.inside.utils.ResultStatus;
import com.myEducation.inside.utils.page.Page;

@Controller
@RequestMapping("${mainPath}/manager/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping
	public String index(){
		return "main/manager/school-list";
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public Page<School> data(Page<School> page){
		return this.schoolService.selectByPage(page);
	}
	
	@RequestMapping("edit")
	public String add(){
		return "main/manager/school-edit";
	}
	
	@RequestMapping("edit/{sId}")
	public String edit(@PathVariable("sId")Long id,Model model){
		model.addAttribute("school", this.schoolService.getById(id));
		return "main/manager/school-edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> tEdit(School school){
		Result<String> result = new Result<String>();
		try {
			if (school.getId() == null) {
				this.schoolService.insert(school);
			} else {
				School s_id = this.schoolService.getById(school.getId());
				if (s_id == null) {
					result.setStatus(ResultStatus.DATA_EXISTS);
					return result;
				}
				s_id.setName(school.getName());
				s_id.setHeadmaster(school.getHeadmaster());
				s_id.setSynopsis(school.getSynopsis());
				s_id.setAddress(school.getAddress());
				this.schoolService.insert(s_id);
			}
			result.setStatus(ResultStatus.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setStatus(ResultStatus.FAIL);
			result.setContent(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("autoSchool")
	@ResponseBody
	public List<HashMap<String, Object>> getSchoolAll(){
		return schoolService.getAll();
	}
}
