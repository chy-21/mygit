package com.myEducation.inside.model.business;

import java.io.Serializable;

public class S_gradeS_class implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6957214270188630822L;
	private int id;
	private int g_id;
	private int c_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

}
