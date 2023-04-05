package com.venky.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resourses_Not_Found extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public Resourses_Not_Found(String message) {
		super();
		this.message = message;
	}

}
