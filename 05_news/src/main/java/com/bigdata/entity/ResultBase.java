package com.bigdata.entity;
import java.io.Serializable;

public class ResultBase<T> implements Serializable {
	private static final long serialVersionUID = 2260784028728105241L;

	/**
	 * 方法调用是否成功
	 */
	private boolean isSuccess = false;
	
	/**
	 * 错误信息
	 */
	private String errorMsg = "";
	
	/**
	 * 错误代码
	 */
	private int errorCode = 0;

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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
