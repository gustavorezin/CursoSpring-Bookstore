package com.gusta.bookstore.resource.exception;

public class StandardError {

	private Long timstamp;
	private Integer status;
	private String errormsg;
	
	public StandardError() {
		super();
	}
	public StandardError(Long timstamp, Integer status, String errormsg) {
		super();
		this.timstamp = timstamp;
		this.status = status;
		this.errormsg = errormsg;
	}
	
	public Long getTimstamp() {
		return timstamp;
	}
	public void setTimstamp(Long timstamp) {
		this.timstamp = timstamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	
	
	
	
}
