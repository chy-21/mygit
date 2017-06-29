package com.myEducation.inside.model;

import java.io.Serializable;

/**
 * 权限模块
 * 
 * @author chy
 *
 */
public class Premission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5791910522313481390L;
	private int id;
	private int user_id;
	private int role_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

}
