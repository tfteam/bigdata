package com.bigdata.common;

/**
 * 所有的dao封装异常信息后抛出此异常
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException() {
		super();
	}
}
