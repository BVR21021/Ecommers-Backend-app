package com.venky.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Resourses_Not_Found.class)
	public String HandleResourcerNotFoundException(Resourses_Not_Found message) {

		return message.getMessage();
	}
}
