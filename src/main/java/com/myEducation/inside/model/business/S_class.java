package com.myEducation.inside.model.business;

import java.io.Serializable;

public class S_class implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -104917955824908166L;

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
