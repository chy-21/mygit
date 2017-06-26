package com.myEducation.inside.utils.baseDao;

import java.io.Serializable;

public interface BaseDao<T, ID extends Serializable> {

	// 添加方法
	public void insert(T t);

	// 修改方法
	public void update(T t);

	// 删除方法
	public void delete(ID id);

	// 查询一条数据
	public T getById(ID id);

}
