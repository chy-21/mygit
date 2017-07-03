package com.myEducation.inside.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.business.Achievement;
import com.myEducation.inside.utils.baseDao.BaseDao;
import com.myEducation.inside.utils.page.Page;

public interface AchievementDao extends BaseDao<Achievement, Long>{
	
	// 分页查询显示
	public List<Achievement> selectByPage(Page<Achievement> page);

	public List<Achievement> getByStuId(@Param("stu_id")Long stu_id);
	
}
