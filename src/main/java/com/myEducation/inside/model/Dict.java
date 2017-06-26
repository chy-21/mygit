package com.myEducation.inside.model;

import java.io.Serializable;

/**
 * 字典类
 * 
 * @author chy
 *
 */
public class Dict implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2016519494386097830L;

	private int id;

	private String name;

	private String value;

	private String type;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
