package com.myEducation.inside.model;

import java.io.Serializable;

/**
 * 角色模块
 * @author chy
 *
 */
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7360506462470654395L;

	private Long id;
	private String name;
	private int status;
	private String createtime;
	private String updatetime;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}
