package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(PostException.class)
	public ResponseEntity<MyError> postExcetption(PostException pe, WebRequest wr){
		
		MyError error = new MyError(LocalDateTime.now(), pe.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CommentException.class)
	public ResponseEntity<MyError> commentExcetption(CommentException ce, WebRequest wr){
		
		MyError error = new MyError(LocalDateTime.now(), ce.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exceptionExcetption(Exception e, WebRequest wr){
		
		MyError error = new MyError(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
}
