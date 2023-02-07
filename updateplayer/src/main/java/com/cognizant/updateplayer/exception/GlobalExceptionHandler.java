package com.cognizant.updateplayer.exception;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationError(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Map<String, String> handleLoginException(HttpMessageNotReadableException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("error", "Provide JSON FORMATED type");
		return error;
	}

	@ExceptionHandler(value = { CannotCreateTransactionException.class })
	public ResponseEntity<?> cannotCreateTransactionException(CannotCreateTransactionException exception,
			WebRequest request) {
		if (exception.contains(ConnectException.class)) {
			log.info("dbException working");
			log.error("DB ConnectException :  {}", exception.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(FeignException.class)
	public Map<String, String> handleFeignException(FeignException f) {
		Map<String, String> error = new HashMap<>();
		error.put("error", "Unauthorized Feign call");
		return error;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MissingRequestHeaderException.class)
	public Map<String, String> MissingRequestHeaderException(MissingRequestHeaderException t) {
		Map<String, String> error = new HashMap<>();
		error.put("error", "token is not present");
		return error;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> ConstraintViolationException(ConstraintViolationException c) {
		Map<String, String> error = new HashMap<>();
		error.put("error", "Constraint violated");
		return error;
	}

}
