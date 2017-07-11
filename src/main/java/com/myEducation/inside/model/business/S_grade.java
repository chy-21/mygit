package com.myEducation.inside.model.business;

import java.io.Serializable;

public class S_grade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8347230040970526670L;

	private int id;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
