package com.myEducation.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myEducation.inside.model.Achievement;
import com.myEducation.inside.service.AchievementService;
import com.myEducation.inside.service.DictService;
import com.myEducation.inside.utils.Result;
import com.myEducation.inside.utils.ResultStatus;
import com.myEducation.inside.utils.page.Page;

@Controller
@RequestMapping("${mainPath}/manager/achievement")
public class AchievementController {

	@Autowired
	private AchievementService achievementService;
	
	@Autowired
	private DictService dictService;
	
	@RequestMapping("")
	public String index(){
		return "main/manager/achievement-list";
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public Page<Achievement> dataList(Page<Achievement> page){
		return this.achievementService.selectByPage(page);
	}
	
	@RequestMapping("edit")
	public String add(Model model){
		initDict(model);
		return "main/manager/achievement-edit";
	}
	
	@RequestMapping("edit/{achId}")
	public String edit(@PathVariable("achId")Long achId,Model model){
		initDict(model);
		model.addAttribute("achievement", this.achievementService.getById(achId));
		return "main/manager/achievement-edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Result<?> achEdit(Achievement achievement){
		Result<String> result = new Result<String>();
		try {
			if (achievement.getId() == null) {
				this.achievementService.insert(achievement);
			}else{
				Achievement ach_id = this.achievementService.getById(achievement.getId());
				if (ach_id.getId() == null) {
					result.setStatus(ResultStatus.DATA_EXISTS);
					return result;
				}
				ach_id.setSubject(achievement.getSubject());
				ach_id.setMidterm(achievement.getMidterm());
				ach_id.setTerminal(achievement.getTerminal());
				this.achievementService.update(ach_id);
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
	public String userDelete(Achievement achievement){
		this.achievementService.dalete(achievement.getId());
		return "main/manager/achievement-list";
	}
	
	public void initDict(Model model){
		model.addAttribute("subject",this.dictService.selectByType("subject"));
	}
}
