package com.myEducation.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.model.Student;
import com.myEducation.inside.service.DictService;
import com.myEducation.inside.service.StudentService;
import com.myEducation.inside.utils.Result;
import com.myEducation.inside.utils.ResultStatus;
import com.myEducation.inside.utils.page.Page;

@Controller
@RequestMapping("${mainPath}/manager/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DictService dictService;

	@RequestMapping
	public String index() {
		return "main/manager/student-list";
	}

	@RequestMapping("data")
	@ResponseBody
	public Page<Student> dataList(Page<Student> page) {
		return this.studentService.selectByPage(page);
	}

	@RequestMapping("edit")
	public String add(Model model) {
		initDict(model);
		return "main/manager/student-edit";
	}
	
	@RequestMapping("edit/{stuId}")
	public String edit(@PathVariable("stuId") Long stuId,Model model) {
		initDict(model);
		model.addAttribute("student", this.studentService.getById(stuId));
		return "main/manager/student-edit";
	}

	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> stuEdit(Student student) {
		Result<String> result = new Result<String>();
		try {
			if (student.getId() == null) {
				this.studentService.insert(student);
			} else {
				Student s_id = this.studentService.getById(student.getId());
				if (s_id == null) {
					result.setStatus(ResultStatus.DATA_ERROR);
					return result;
				}
				s_id.setName(student.getName());
				s_id.setSex(student.getSex());
				s_id.setAge(student.getSex());
				s_id.setProvince(student.getProvince());
				s_id.setNation(student.getNation());
				s_id.setS_id(student.getS_id());;
				s_id.setG_id(student.getG_id());
				s_id.setC_id(student.getC_id());
				this.studentService.update(s_id);
				result.setStatus(ResultStatus.SUCCESS);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setStatus(ResultStatus.FAIL);
			result.setContent(e.getMessage());
		}
		return result;
	}
	
	public void initDict(Model model){
		model.addAttribute("province",this.dictService.selectByType("province"));
		model.addAttribute("nation",this.dictService.selectByType("nation"));
	}
}
