package com.bigdata.entity;
import java.io.Serializable;
import java.util.Map;

public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 方法调用是否成功
	 */
	private boolean isSuccess = false;
	
	/**
	 * 错误信息
	 */
	private Map<Integer, String> errorMap = null;
	
	private T value;

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Map<Integer, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<Integer, String> errorMap) {
		this.errorMap = errorMap;
	}
}