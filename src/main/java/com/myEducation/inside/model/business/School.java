package com.myEducation.inside.model.business;

import java.io.Serializable;

/**
 * 学校类
 * 
 * @author chy
 *
 */
public class School implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4316172762642292005L;

	private Long id;

	private String name;

	private String headmaster;
	// 学校简介
	private String synopsis;
	// 学校地址
	private String address;
	// 成立时间
	private String entrytime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getHeadmaster() {
		return headmaster;
	}

	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
	}

}
