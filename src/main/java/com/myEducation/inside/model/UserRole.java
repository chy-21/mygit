package com.myEducation.inside.model;

import java.io.Serializable;

/**
 * 角色下用户管理
 * @author Jat
 *
 */
public class UserRole implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4027967118062571458L;
	private Integer id;
	private int roleId;
	private int userId;
	private String createTime;
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
