package com.su.dto;

public class Result<T> {
	private boolean success;//是否成功
	private T data;//成功时返回的数据
	private String error;//错误信息
	
	/**
	 * 成功的构造器
	 * @param success
	 * @param data
	 */
	public Result(boolean success,T data) {
		this.success=success;
		this.data=data;
	}
	
	//失败的构造器
	public Result(boolean success,String error) {
		this.success=success;
		this.error=error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
