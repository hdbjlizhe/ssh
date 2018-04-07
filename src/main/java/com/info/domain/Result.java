package com.info.domain;

public class Result<T> {
	private Integer code;//结果码
	private String msg;//结果信息
	private T data;		//结果数据
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}	
