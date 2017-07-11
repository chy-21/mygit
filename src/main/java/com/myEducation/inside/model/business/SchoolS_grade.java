package com.myEducation.inside.model.business;

import java.io.Serializable;

public class SchoolS_grade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5287502915647442171L;
	private int id;
	private int s_id;
	private int g_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

}
