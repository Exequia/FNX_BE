package com.fnx.be.util;

public class RestResponse {

	private Integer status;
	private String msg;
	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
