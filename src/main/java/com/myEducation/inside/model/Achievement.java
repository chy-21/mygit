package com.myEducation.inside.model;

import java.io.Serializable;

public class Achievement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6050932191620566875L;

	private Long id;
	// 学科
	private String subject;
	// 期中考试
	private int midterm;
	// 期末考试
	private int terminal;
	// 对应学生ID
	private Long stu_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMidterm() {
		return midterm;
	}

	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}

	public int getTerminal() {
		return terminal;
	}

	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}

	public Long getStu_id() {
		return stu_id;
	}

	public void setStu_id(Long stu_id) {
		this.stu_id = stu_id;
	}

}
