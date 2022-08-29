package com.project.babynaming.controller;


import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.entity.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<Message> exceptionHandler(ResourceNotFoundException cne){
	Message errorResponse=new Message();
	errorResponse.setMessage(cne.getMessage());
    errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
    return new ResponseEntity<Message>(errorResponse, HttpStatus.OK);
}

@ExceptionHandler(Exception.class)
public ResponseEntity<Message> exceptionHandler(Exception e){
	Message errorResponse=new Message();
   errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
   errorResponse.setMessage(e.getMessage());
   return new ResponseEntity<Message>(errorResponse, HttpStatus.OK);
}
}

