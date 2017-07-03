package com.myEducation.inside.model;

import java.io.Serializable;

/**
 * 用户模型
 * 
 * @author chy
 *
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -836954328833559243L;

	private Integer id;

	private String username;

	private String password;

	// 用户状态：0为启用，1为禁用
	private int status;

	private int isAdmin;

	private String entrytime;

	private String updatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
