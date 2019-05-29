package org.hs.exceptions.handlers;

import javax.persistence.EntityNotFoundException;

import org.hs.exceptions.api.ApiErrorResponse;
import org.hs.exceptions.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiErrorResponse handleEntityNotFound(EntityNotFoundException ex) {
		return new ApiErrorResponse(HttpStatus.NOT_FOUND, "Entity not found", ex);
	}

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	public ApiErrorResponse handleCustomException(CustomException ex) {
		return new ApiErrorResponse(HttpStatus.NOT_ACCEPTABLE, "Custom exception", ex);
	}
}
