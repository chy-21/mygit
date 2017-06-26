package com.myEducation.inside.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myEducation.inside.model.Dict;
import com.myEducation.inside.utils.baseDao.BaseDao;

public interface DictDao extends BaseDao<Dict, Long>{

	public List<Dict> selectByType(@Param("type")String type);
	
}
