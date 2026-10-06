package com.cg.bankapp.exceptionhandler;
import org.axonframework.queryhandling.QueryExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<String> handelQueryExceptionHandler(QueryExecutionException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
}
