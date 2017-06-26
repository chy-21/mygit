package com.myEducation.inside.utils;

/**
 * 返回状态码和描述的枚举
 * @author Jat
 *
 */
public enum ResultStatus {
	
	SUCCESS(0, "success"),
	PASSWORD_ERROR(1,"密码错误"),
	ACCOUNT_NOTFOUND(2,"找不到用户"),
	DATA_NOTFOUND(3,"找不到数据"),
	DATA_EXISTS(4,"数据已存在"),
	DATA_ERROR(8,"数据出现异常"),
	USER_EXISTENCE(9,"该用户已存在"),
	USER_PASSWORD_ERROR(11,"用户密码错误"),
	USER_PASSWORD_REPEAT(12,"新密码与原密码重复"),
	
	FAIL(10001, "操作失败."),
	TIME_OUT(10002,"请求超时");
	
	private int status;
	private String msg;

	private ResultStatus(int status, String msg){
		this.status = status;
		this.msg = msg;
	}

	public int getStatus(){
		return this.status;
	}

	public String getMsg() {
		return this.msg;
	}
	
}
