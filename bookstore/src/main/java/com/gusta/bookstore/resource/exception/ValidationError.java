package com.gusta.bookstore.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();
	
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timstamp, Integer status, String errormsg) {
		super(timstamp, status, errormsg);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	public void addErrors(String field, String message) {
		this.errors.add(new FieldMessage(field, message));
	}

	
	
}
