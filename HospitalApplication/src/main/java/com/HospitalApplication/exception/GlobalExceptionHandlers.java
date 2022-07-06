package com.HospitalApplication.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers {

	@ExceptionHandler(GivenIdNotFoundException.class)
	public ResponseEntity<Object> handleGivenIdNotFoundException(){
		return new ResponseEntity<Object>("Given Id is not available.",HttpStatus.NOT_FOUND);
	}
		
    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<Object> handleNoRecordFoundException1(){
    	return new ResponseEntity<Object>("No record Available.", HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoSuchDataFoundException.class)
    public ResponseEntity<Object> handleNoSuchDataFoundException(){
    	return new ResponseEntity<Object>("Record not found." , HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value= {MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String,String>>handleValidationExceptions(MethodArgumentNotValidException ex){
    	Map<String, String> errors=new HashMap<>();
    	ex.getBindingResult().getAllErrors().forEach((error)->{
    		
    		String fieldName=((FieldError) error).getField();
    		String errorMessage=error.getDefaultMessage();
    		 errors.put(fieldName,errorMessage);
    	});
    	return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
    }
}
